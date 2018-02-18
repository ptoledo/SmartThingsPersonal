/**
 *  CentralLog - BulbGroup SmartApp
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
  name: "CentralLog - BulbGroup SmartApp",
  namespace: "ptoledo",
  author: "Pedro Toledo",
  description: "This SmartApp allows the linking of a \"CentralLog - BulbGroup Device\" to a set of bulbs",
  category: "SmartThings Labs",
  iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
  iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
  iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png"
)

preferences {
  section("Set the \"CentralLog - BulbGroup Device\"") {
    input "presenceSwitchLiving", "capability.switch", title: "Pick your BulbGroup device", multiple: false, required: true
  }
  section("Set the bulbs on the group to be controlled"){
    input "lightsLiving", "capability.switch", title: "Pick your Living lights", multiple: true, required: true
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
	// TODO: subscribe to attributes, devices, locations, etc.
}