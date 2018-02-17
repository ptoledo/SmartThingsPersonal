/**
 *  CentralLog - BulbGroup Device
 *
 *  Copyright 2018 Pedro Toledo
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
metadata {
	definition (name: "CentralLog - BulbGroup Device", namespace: "ptoledo", author: "Pedro Toledo") {
		capability "Color Control"
		capability "Color Temperature"
		capability "Switch"
		capability "Switch Level"
	}

    tiles (scale: 2) {
      multiAttributeTile(name:"main", type:"generic", width:6, height:4) {
        tileAttribute("device.cleaning", canChangeIcon: true, key: "PRIMARY_CONTROL") {
          attributeState "ready"   , label: "", icon: "st.illuminance.illuminance.bright", backgroundColor: "#00a0dc", action: "toWrapper"
          attributeState "cleaning", label: "", icon: "st.motion.motion.active",           backgroundColor: "#00dca0", action: "toWrapper" //Lothar check arrow
        }
        tileAttribute ("device.cleaning", key: "SECONDARY_CONTROL") {
          attributeState "device.cleaning", label:'${currentValue}'
        }
      }
    }
    
	simulator {
		// TODO: define status and reply messages here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'hue' attribute
	// TODO: handle 'saturation' attribute
	// TODO: handle 'color' attribute
	// TODO: handle 'colorTemperature' attribute
	// TODO: handle 'switch' attribute
	// TODO: handle 'level' attribute

}

// handle commands
def setHue() {
	log.debug "Executing 'setHue'"
	// TODO: handle 'setHue' command
}

def setSaturation() {
	log.debug "Executing 'setSaturation'"
	// TODO: handle 'setSaturation' command
}

def setColor() {
	log.debug "Executing 'setColor'"
	// TODO: handle 'setColor' command
}

def setColorTemperature() {
	log.debug "Executing 'setColorTemperature'"
	// TODO: handle 'setColorTemperature' command
}

def on() {
	log.debug "Executing 'on'"
	// TODO: handle 'on' command
}

def off() {
	log.debug "Executing 'off'"
	// TODO: handle 'off' command
}

def setLevel() {
	log.debug "Executing 'setLevel'"
	// TODO: handle 'setLevel' command
}