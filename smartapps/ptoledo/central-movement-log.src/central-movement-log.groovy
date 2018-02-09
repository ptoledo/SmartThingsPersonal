/**
 *  Central Movement Log
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

definition(
  name: "Central Movement Log",
  namespace: "ptoledo",
  author: "Pedro Toledo",
  description: "Central Movement Log monitoring App",
  category: "SmartThings Labs",
  iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
  iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
  iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")
    
preferences {
  section("Set the sensors") {
    input "sensorMotion", "capability.motionSensor",  title: "Pick your motion sensors",  required: false, multiple: true
    input "sensorDoor",   "capability.contactSensor", title: "Pick your contact sensors", required: false, multiple: true
  }
  section("Set the logger") {
    input "logger", "capability.Refresh", title: "Pick your logger", required: true, multiple: false
  }
}

def installed() {
  log.debug "Installed with settings: ${settings}"
  initialize()
}

def initialize() {
  subscribe(sensorMotion, "motion", communicateEvent)
  subscribe(sensorDoor, "contact", communicateEvent)
}

def updated() {
  log.debug "Updated with settings: ${settings}"
  unsubscribe()
  initialize()
}

def communicateEvent(evt) {
  logger.addEvent(evt.deviceId, evt.value);
}