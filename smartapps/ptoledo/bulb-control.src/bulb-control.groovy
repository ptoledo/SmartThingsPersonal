/**
*  Bulb Control
*
*  Copyright 2016 Pedro Toledo
*
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*/
definition(
    name: "Bulb Control",
    namespace: "ptoledo",
    author: "Pedro Toledo",
    description: "To interface the LIFX Bulbs to ensure on/off/color behavior",
    category: "SmartThings Labs",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
    page(name: "Configuration")
}

def Configuration() {
    dynamicPage(name: "Configuration", title: "", install: true, uninstall: true) {
        section {
        	input name: "theSwitch", title: "Select your controling switch", type: "capability.switch", required: true
            input name: "theSwitchDimm", title: "Select your controling switch", type: "capability.switch", required: true
            input name: "theBulb", title: "Select your bulb", type: "capability.switch", required: true, submitOnChange: true, multiple: true
        }
        if(theBulb) {
            def color = true;
            theBulb.each {
            	if(!it.hasAttribute("color")){
                	color = false;
                }
            }
			if(color) {
                section("On") {
                    input "hue", "number", title: "hue", required: true, range: "0..100"
                    input "saturation", "number", title: "saturation", required: true, range: "0..100"
		    		input "temperature", "number", title: "temperature. Set 0 for color", required: true, range: "2499..9000", defaultValue: "2499"
                    input "level", "number", title: "level", required: true, range: "0..100"                    
                }
                section("On (dimm)") {
                    input "hueDimm", "number", title: "hue", required: true, range: "0..100"
                    input "saturationDimm", "number", title: "saturation", required: true, range: "0..100"
		    		input "temperatureDimm", "number", title: "temperature. Set 0 for color", required: true, range: "2499..9000", defaultValue: "2499"
                    input "levelDimm", "number", title: "level", required: true, range: "0..100"                    
                }
   			} else {
            	section("On") {
		    		input "temperature", "number", title: "temperature", required: true, range: "2500..9000"
                    input "level", "number", title: "level", required: true, range: "0..100"
                }
            	section("On (dimm)") {
		    		input "temperatureDimm", "number", title: "temperature", required: true, range: "2500..9000"
                    input "levelDimm", "number", title: "level", required: true, range: "0..100"
                }                
		    }
   		}
        section() {
			label title: "Assign a name", required: false
			mode title: "Set for specific mode(s)", required: false
		}
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    subscribe(theSwitch, "switch", bulbHandler)
    subscribe(theSwitchDimm, "switch", bulbHandler)
}

def bulbHandler(evt) {
	if(evt.value == "on") {
       	onBulb();
    } else {
        if(theSwitch.currentSwitch == "on" || theSwitchDimm.currentSwitch == "on"){
        	onBulb()
        } else {
        	offBulb()
        }
    }
}

def onBulb() {
    theBulb.each {
		log.debug "on try "+it.displayName
		def action = 0
        if (it.currentSwitch != "on") {
        	if(theSwitchDimm.currentSwitch == "on"){
            	action = 1
            }
            if(theSwitch.currentSwitch == "on"){
                action = 2
            }
        } else {
        	if(theSwitchDimm.currentSwitch == "on" && theSwitch.currentSwitch != "on"){
            	if(temperatureDimm == 2499 && (it.currentHue != hueDimm || it.currentSaturation != saturationDimm || it.currentLevel != levelDimm)) {
            		action = 1
                }
                if(temperatureDimm != 2499 && (it.currentColorTemperature != temperatureDimm || it.currentLevel != levelDimm)) {
            		action = 1
                }
            } else {
            	if(temperature == 2499 && (it.currentHue != hue || it.currentSaturation != saturation || it.currentLevel != level)) {
            		action = 2
                }
                if(temperature != 2499 && (it.currentColorTemperature != temperature || it.currentLevel != level)) {
            		action = 2
                }
            }
        }
        switch(action){
        	case 0:
            	log.debug "on done "+it.displayName
                break
            case 1:
                it.setLevel(levelDimm)            
                if(temperatureDimm == 2499){
                    it.setHue(hueDimm)
                    it.setSaturation(saturationDimm)
                } else {
                    it.setColorTemperature(temperatureDimm)
                }
                runIn(1, onBulb)
                break
            case 2:
                it.setLevel(level)
                if(temperature == 2499){
                    it.setHue(hue)
                    it.setSaturation(saturation)
                } else {
                    it.setColorTemperature(temperature)
                }
                runIn(1, onBulb)
                break
            default:
            	log.debug "on done (error) "+it.displayName
                break
        }
    }
}

def offBulb() {
	log.debug "off try"
    	theBulb.each {
		if(it.currentswitch != "off"){
	    	it.off()
	        runIn(1,offBulb)
	    } else {
	    	log.debug "off done "+it.displayName
	    }
    }
}

