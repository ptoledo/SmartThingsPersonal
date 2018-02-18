/**
 *  CentralLog - LogInspector
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
    name: "CentralLog - LogInspector",
    namespace: "ptoledo",
    author: "Pedro Toledo",
    description: "This smartapp allows to receive commands and information from \"CentralLog - Device\" and trigger actions over CentralLog device handlers",
    category: "",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
  section("Set the \"CentralLog - Device\"") {
    input "theCentralLog", "capability.notification", title: "Pick your CentralLog device", multiple: false, required: true
  }
  section("Set the \"CentralLog - BulbGroup Device\"") {
    input "theBulbGroupDevice", "capability.switch", title: "Pick your BulbGroup device", multiple: true, required: true
  }
  section("Set the Sensors to watch") {
    input "theSensors", "capability.motionSensor", title: "Pick your Motion Sensor devices", multiple: true, required: false
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
  subscribe(theCentralLog, "notification.deviceNotification", logHandler)
}

def logHandler(evt) {
  def last = 42
  def buff = 0
  theSensors.each{
    theCentralLog.getLastEventPositionExternal(it.id, "active", "1")
    buff = theCentralLog.currentValue("chanel1")
    if(buff != -1 && buff<last){
      last=buff
    }
  }
  if(last<2){
    theBulbGroupDevice.on()
  } else {
    theBulbGroupDevice.off()
  }
}
