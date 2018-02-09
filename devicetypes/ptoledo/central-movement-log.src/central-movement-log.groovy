/**
 *  Central Movement Log
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

metadata {
	definition (name: "Central Movement Log", namespace: "ptoledo", author: "Pedro Toledo Correa") {
        // Creating the log capability to differentiate function
        capability "Refresh"
        // Information
        attribute 
        attribute "hit0name", "string"
        attribute "hit1name", "string"
        attribute "hit2name", "string"
        attribute "hit3name", "string"
        attribute "hit4name", "string"
        attribute "hit5name", "string"
        attribute "hit6name", "string"
        attribute "hit7name", "string"
        attribute "hit8name", "string"
        attribute "hit9name", "string"
        attribute "hit0type", "string"
        attribute "hit1type", "string"
        attribute "hit2type", "string"
        attribute "hit3type", "string"
        attribute "hit4type", "string"
        attribute "hit5type", "string"
        attribute "hit6type", "string"
        attribute "hit7type", "string"
        attribute "hit8type", "string"
        attribute "hit9type", "string"
        attribute "hit0time", "number"
        attribute "hit1time", "number"
        attribute "hit2time", "number"
        attribute "hit3time", "number"
        attribute "hit4time", "number"
        attribute "hit5time", "number"
        attribute "hit6time", "number"
        attribute "hit7time", "number"
        attribute "hit8time", "number"
        attribute "hit9time", "number"
        // Resets the state of the device to empty
        command "clear"
		command "addEvent", ["string", "string"]
	}
	tiles (scale: 2) {
        multiAttributeTile(name:"main", type:"generic", width:6, height:4) {
			tileAttribute("device.updating", canChangeIcon: true, key: "PRIMARY_CONTROL") {
                attributeState "ready"     , label: "", icon: "st.illuminance.illuminance.bright",   backgroundColor: "#00a0dc", action: "clear"
                attributeState "refreshing", label: "", icon: "st.illuminance.illuminance.bright", backgroundColor: "#00dca0", action: "clear"
            }
            tileAttribute ("device.updating", key: "SECONDARY_CONTROL") {
				attributeState "device.updating", label:'${currentValue}'
			}
		}
        standardTile("hit0name", "device.hit0name", width: 3, height: 1) {
             state "hit0name", label: '${currentValue}'
        }
        standardTile("hit0type", "device.hit0type", width: 1, height: 1) {
             state "hit0_type", label: '${currentValue}'
        }
        standardTile("hit0time", "device.hit0time", width: 2, height: 1) {
             state "hit0time", label: '${currentValue}'
        }
        standardTile("hit1name", "device.hit1name", width: 3, height: 1) {
             state "hit1_name", label: '${currentValue}'
        }
        standardTile("hit1type", "device.hit1type", width: 1, height: 1) {
             state "hit1type", label: '${currentValue}'
        }
        standardTile("hit1time", "device.hit1time", width: 2, height: 1) {
             state "hit1time", label: '${currentValue}'
        }
        standardTile("hit2name", "device.hit2name", width: 3, height: 1) {
             state "hit2name", label: '${currentValue}'
        }
        standardTile("hit2type", "device.hit2type", width: 1, height: 1) {
             state "hit2type", label: '${currentValue}'
        }
        standardTile("hit2time", "device.hit2time", width: 2, height: 1) {
             state "hit2time", label: '${currentValue}'
        }
        standardTile("hit3name", "device.hit3name", width: 3, height: 1) {
             state "hit3name", label: '${currentValue}'
        }
        standardTile("hit3type", "device.hit3type", width: 1, height: 1) {
             state "hit3type", label: '${currentValue}'
        }
        standardTile("hit3time", "device.hit3time", width: 2, height: 1) {
             state "hit3time", label: '${currentValue}'
        }
	}
    preferences {
    }
    simulator {
		// TODO: define status and reply messages here
	}
}

// Clears the current list stack
def clear() {
    sendEvent(name: "updating", value: "refreshing")
    sendEvent(name: "hit0name", value: "")
    sendEvent(name: "hit0type", value: "")
    sendEvent(name: "hit0time", value: "")
    sendEvent(name: "hit1name", value: "")
    sendEvent(name: "hit1type", value: "")
    sendEvent(name: "hit1time", value: "")
    sendEvent(name: "hit2name", value: "")
    sendEvent(name: "hit2type", value: "")
    sendEvent(name: "hit2time", value: "")
    sendEvent(name: "hit3name", value: "")
    sendEvent(name: "hit3type", value: "")
    sendEvent(name: "hit3time", value: "")
    sendEvent(name: "hit4name", value: "")
    sendEvent(name: "hit4type", value: "")
    sendEvent(name: "hit4time", value: "")
    sendEvent(name: "hit5name", value: "")
    sendEvent(name: "hit5type", value: "")
    sendEvent(name: "hit5time", value: "")
    sendEvent(name: "hit6name", value: "")
    sendEvent(name: "hit6type", value: "")
    sendEvent(name: "hit6time", value: "")
    sendEvent(name: "hit7name", value: "")
    sendEvent(name: "hit7type", value: "")
    sendEvent(name: "hit7time", value: "")
    sendEvent(name: "hit8name", value: "")
    sendEvent(name: "hit8type", value: "")
    sendEvent(name: "hit8time", value: "")
    sendEvent(name: "hit9name", value: "")
    sendEvent(name: "hit9type", value: "")
    sendEvent(name: "hit9time", value: "")
    sendEvent(name: "updating", value: "ready")
}

// Adding event to the log
def addEvent(theName, theType) {
  sendEvent(name: "updating", value: "refreshing")
  sendEvent(name: "hit9name", value: device.currentValue("hit8name"))
  sendEvent(name: "hit8name", value: device.currentValue("hit7name"))
  sendEvent(name: "hit7name", value: device.currentValue("hit6name"))
  sendEvent(name: "hit6name", value: device.currentValue("hit5name"))
  sendEvent(name: "hit5name", value: device.currentValue("hit4name"))
  sendEvent(name: "hit4name", value: device.currentValue("hit3name"))
  sendEvent(name: "hit3name", value: device.currentValue("hit2name"))
  sendEvent(name: "hit2name", value: device.currentValue("hit1name"))
  sendEvent(name: "hit1name", value: device.currentValue("hit0name"))
  sendEvent(name: "hit0name", value: theName)
  sendEvent(name: "hit9type", value: device.currentValue("hit8type"))
  sendEvent(name: "hit8type", value: device.currentValue("hit7type"))
  sendEvent(name: "hit7type", value: device.currentValue("hit6type"))
  sendEvent(name: "hit6type", value: device.currentValue("hit5type"))
  sendEvent(name: "hit5type", value: device.currentValue("hit4type"))
  sendEvent(name: "hit4type", value: device.currentValue("hit3type"))
  sendEvent(name: "hit3type", value: device.currentValue("hit2type"))
  sendEvent(name: "hit2type", value: device.currentValue("hit1type"))
  sendEvent(name: "hit1type", value: device.currentValue("hit0type"))
  sendEvent(name: "hit0type", value: theType)
  sendEvent(name: "hit9time", value: device.currentValue("hit8time"))
  sendEvent(name: "hit8time", value: device.currentValue("hit7time"))
  sendEvent(name: "hit7time", value: device.currentValue("hit6time"))
  sendEvent(name: "hit6time", value: device.currentValue("hit5time"))
  sendEvent(name: "hit5time", value: device.currentValue("hit4time"))
  sendEvent(name: "hit4time", value: device.currentValue("hit3time"))
  sendEvent(name: "hit3time", value: device.currentValue("hit2time"))
  sendEvent(name: "hit2time", value: device.currentValue("hit1time"))
  sendEvent(name: "hit1time", value: device.currentValue("hit0time"))
  sendEvent(name: "hit0time", value: now())
  sendEvent(name: "updating", value: "ready")
}

// Parse events into attributes
def parse(String description) {
}