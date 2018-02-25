/**
 *  CentralLog - BulbGroup Action
 *
 *  Copyright 2018 Pedro Toledo Correa
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
  name: "CentralLog - BulbGroup Action",
  namespace: "ptoledo",
  author: "Pedro Toledo Correa",
  description: "To inspect the \"CentralLog - BulbGroup Device\" and execute their refresh actions.",
  category: "SmartThings Labs",
  iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
  iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
  iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png"
)


preferences {
  section("Select your devices") {
    input "bulbGroups", "capability.refresh", title: "Pick your BulbGroup devices", multiple: true, required: false
    input "bulbs",      "capability.switch",  title: "Pick your Bulbs",             multiple: true, required: false
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
  subscribe(bulbGroups, "refresh", refreshBulbs)
}

def getBulb(id){
  def runBulb = null
  bulbs.each{
    if(it.getId() == id){
      runBulb = it
      return true
    }
  }
  return runBulb
}

def refreshBulbs(evt) {
  def runBulb = parseJson(evt.data).bulb
  switch (parseJson(evt.data).name) {
    case "switch":
      mySwitch([bulb: runBulb, value: parseJson(evt.data).value])
      break
    case "color":
      mySetColor([bulb: runBulb, value: parseJson(evt.data).value])
      break
    case "level":
      mySetLevel([bulb: runBulb, value: parseJson(evt.data).value])
      break
    case "colorTemp":
      mySetColorTemperature([bulb: runBulb, value: parseJson(evt.data).value])
      break
    default:
      log.debug "Uncatched: ${parseJson(evt.data).name} with value: ${parseJson(evt.data).value}"
      break
  }
}

def mySwitch(data) {
  def bulb = getBulb(data.bulb)
  //log.debug "try ${data}"
  if(bulb != null && bulb.currentValue("switch") != data.value) {
    if (data.value == "on") {
      bulb.on()
    } else {
      bulb.off()
    }
    runIn(1, "mySwitch", [data: data]) 
  }
}

def mySetColor(data) {
  def bulb = getBulb(data.bulb)
  //log.debug "try ${data}"
  if(bulb != null && bulb.currentValue("color") != data.value) {
    bulb.setColor(data.value)
    runIn(1, "mySetColor", [data: data]) 
  }
}

def mySetColorTemperature(data) {
  def bulb = getBulb(data.bulb)
  //log.debug "try ${data}"
  if(bulb != null && bulb.currentValue("colorTemperature") != data.value) {
    bulb.setColorTemperature(data.value)
    runIn(1, "mySetColorTemperature", [data: data]) 
  }
}

def mySetLevel(data) {
  def bulb = getBulb(data.bulb)
  //log.debug "try ${data}"
  if(bulb != null && bulb.currentValue("level") != data.value) {
    bulb.setLevel(data.value)
    runIn(1, "mySetLevel", [data: data])
  }
}




