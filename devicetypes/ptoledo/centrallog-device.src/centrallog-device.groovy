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
	definition (name: "CentralLog - Device", namespace: "ptoledo", author: "Pedro Toledo Correa") {
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
        attribute "hitAname", "string"
        attribute "hitBname", "string"
        attribute "hitCname", "string"
        attribute "hitDname", "string"
        attribute "hitEname", "string"
        attribute "hitFname", "string"
        attribute "hitGname", "string"
        attribute "hitHname", "string"
        attribute "hitIname", "string"
        attribute "hitJname", "string"
        attribute "hitKname", "string"
        attribute "hitLname", "string"
        attribute "hitMname", "string"
        attribute "hitNname", "string"
        attribute "hitOname", "string"
        attribute "hitPname", "string"
        attribute "hitQname", "string"
        attribute "hitRname", "string"
        attribute "hitSname", "string"
        attribute "hitTname", "string"
        attribute "hitUname", "string"
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
        attribute "hitAtype", "string"
        attribute "hitBtype", "string"
        attribute "hitCtype", "string"
        attribute "hitDtype", "string"
        attribute "hitEtype", "string"
        attribute "hitFtype", "string"
        attribute "hitGtype", "string"
        attribute "hitHtype", "string"
        attribute "hitItype", "string"
        attribute "hitJtype", "string"
        attribute "hitKtype", "string"
        attribute "hitLtype", "string"
        attribute "hitMtype", "string"
        attribute "hitNtype", "string"
        attribute "hitOtype", "string"
        attribute "hitPtype", "string"
        attribute "hitQtype", "string"
        attribute "hitRtype", "string"
        attribute "hitStype", "string"
        attribute "hitTtype", "string"
        attribute "hitUtype", "string"
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
        attribute "hitAtime", "number"
        attribute "hitBtime", "number"
        attribute "hitCtime", "number"
        attribute "hitDtime", "number"
        attribute "hitEtime", "number"
        attribute "hitFtime", "number"
        attribute "hitGtime", "number"
        attribute "hitHtime", "number"
        attribute "hitItime", "number"
        attribute "hitJtime", "number"
        attribute "hitKtime", "number"
        attribute "hitLtime", "number"
        attribute "hitMtime", "number"
        attribute "hitNtime", "number"
        attribute "hitOtime", "number"
        attribute "hitPtime", "number"
        attribute "hitQtime", "number"
        attribute "hitRtime", "number"
        attribute "hitStime", "number"
        attribute "hitTtime", "number"
        attribute "hitUtime", "number"
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
    sendEvent(name: "hitAname", value: "")
    sendEvent(name: "hitAtype", value: "")
    sendEvent(name: "hitAtime", value: "")
    sendEvent(name: "hitBname", value: "")
    sendEvent(name: "hitBtype", value: "")
    sendEvent(name: "hitBtime", value: "")
    sendEvent(name: "hitCname", value: "")
    sendEvent(name: "hitCtype", value: "")
    sendEvent(name: "hitCtime", value: "")
    sendEvent(name: "hitDname", value: "")
    sendEvent(name: "hitDtype", value: "")
    sendEvent(name: "hitDtime", value: "")
    sendEvent(name: "hitEname", value: "")
    sendEvent(name: "hitEtype", value: "")
    sendEvent(name: "hitEtime", value: "")
    sendEvent(name: "hitFname", value: "")
    sendEvent(name: "hitFtype", value: "")
    sendEvent(name: "hitFtime", value: "")
    sendEvent(name: "hitGname", value: "")
    sendEvent(name: "hitGtype", value: "")
    sendEvent(name: "hitGtime", value: "")
    sendEvent(name: "hitHname", value: "")
    sendEvent(name: "hitHtype", value: "")
    sendEvent(name: "hitHtime", value: "")
    sendEvent(name: "hitIname", value: "")
    sendEvent(name: "hitItype", value: "")
    sendEvent(name: "hitItime", value: "")
    sendEvent(name: "hitJname", value: "")
    sendEvent(name: "hitJtype", value: "")
    sendEvent(name: "hitJtime", value: "")
    sendEvent(name: "hitKname", value: "")
    sendEvent(name: "hitKtype", value: "")
    sendEvent(name: "hitKtime", value: "")
    sendEvent(name: "hitLname", value: "")
    sendEvent(name: "hitLtype", value: "")
    sendEvent(name: "hitLtime", value: "")
    sendEvent(name: "hitMname", value: "")
    sendEvent(name: "hitMtype", value: "")
    sendEvent(name: "hitMtime", value: "")
    sendEvent(name: "hitNname", value: "")
    sendEvent(name: "hitNtype", value: "")
    sendEvent(name: "hitNtime", value: "")
    sendEvent(name: "hitOname", value: "")
    sendEvent(name: "hitOtype", value: "")
    sendEvent(name: "hitOtime", value: "")
    sendEvent(name: "hitPname", value: "")
    sendEvent(name: "hitPtype", value: "")
    sendEvent(name: "hitPtime", value: "")
    sendEvent(name: "hitQname", value: "")
    sendEvent(name: "hitQtype", value: "")
    sendEvent(name: "hitQtime", value: "")
    sendEvent(name: "hitRname", value: "")
    sendEvent(name: "hitRtype", value: "")
    sendEvent(name: "hitRtime", value: "")
    sendEvent(name: "hitSname", value: "")
    sendEvent(name: "hitStype", value: "")
    sendEvent(name: "hitStime", value: "")
    sendEvent(name: "hitTname", value: "")
    sendEvent(name: "hitTtype", value: "")
    sendEvent(name: "hitTtime", value: "")
    sendEvent(name: "hitUname", value: "")
    sendEvent(name: "hitUtype", value: "")
    sendEvent(name: "hitUtime", value: "")
    sendEvent(name: "updating", value: "ready")
}

// Adding event to the log
def addEvent(theName, theType) {
  sendEvent(name: "updating", value: "refreshing")
  sendEvent(name: "hitUname", value: device.currentValue("hitTname"))
  sendEvent(name: "hitTname", value: device.currentValue("hitSname"))
  sendEvent(name: "hitSname", value: device.currentValue("hitRname"))
  sendEvent(name: "hitRname", value: device.currentValue("hitQname"))
  sendEvent(name: "hitQname", value: device.currentValue("hitPname"))
  sendEvent(name: "hitPname", value: device.currentValue("hitOname"))
  sendEvent(name: "hitOname", value: device.currentValue("hitNname"))
  sendEvent(name: "hitNname", value: device.currentValue("hitMname"))
  sendEvent(name: "hitMname", value: device.currentValue("hitLname"))
  sendEvent(name: "hitLname", value: device.currentValue("hitKname"))
  sendEvent(name: "hitKname", value: device.currentValue("hitJname"))
  sendEvent(name: "hitJname", value: device.currentValue("hitIname"))
  sendEvent(name: "hitIname", value: device.currentValue("hitHname"))
  sendEvent(name: "hitHname", value: device.currentValue("hitGname"))
  sendEvent(name: "hitGname", value: device.currentValue("hitFname"))
  sendEvent(name: "hitFname", value: device.currentValue("hitEname"))
  sendEvent(name: "hitEname", value: device.currentValue("hitDname"))
  sendEvent(name: "hitDname", value: device.currentValue("hitCname"))
  sendEvent(name: "hitCname", value: device.currentValue("hitBname"))
  sendEvent(name: "hitBname", value: device.currentValue("hitAname"))
  sendEvent(name: "hitAname", value: device.currentValue("hit9name"))
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
  sendEvent(name: "hitUtype", value: device.currentValue("hitTtype"))
  sendEvent(name: "hitTtype", value: device.currentValue("hitStype"))
  sendEvent(name: "hitStype", value: device.currentValue("hitRtype"))
  sendEvent(name: "hitRtype", value: device.currentValue("hitQtype"))
  sendEvent(name: "hitQtype", value: device.currentValue("hitPtype"))
  sendEvent(name: "hitPtype", value: device.currentValue("hitOtype"))
  sendEvent(name: "hitOtype", value: device.currentValue("hitNtype"))
  sendEvent(name: "hitNtype", value: device.currentValue("hitMtype"))
  sendEvent(name: "hitMtype", value: device.currentValue("hitLtype"))
  sendEvent(name: "hitLtype", value: device.currentValue("hitKtype"))
  sendEvent(name: "hitKtype", value: device.currentValue("hitJtype"))
  sendEvent(name: "hitJtype", value: device.currentValue("hitItype"))
  sendEvent(name: "hitItype", value: device.currentValue("hitHtype"))
  sendEvent(name: "hitHtype", value: device.currentValue("hitGtype"))
  sendEvent(name: "hitGtype", value: device.currentValue("hitFtype"))
  sendEvent(name: "hitFtype", value: device.currentValue("hitEtype"))
  sendEvent(name: "hitEtype", value: device.currentValue("hitDtype"))
  sendEvent(name: "hitDtype", value: device.currentValue("hitCtype"))
  sendEvent(name: "hitCtype", value: device.currentValue("hitBtype"))
  sendEvent(name: "hitBtype", value: device.currentValue("hitAtype"))
  sendEvent(name: "hitAtype", value: device.currentValue("hit9type"))
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
  sendEvent(name: "hitUtime", value: device.currentValue("hitTtime"))
  sendEvent(name: "hitTtime", value: device.currentValue("hitStime"))
  sendEvent(name: "hitStime", value: device.currentValue("hitRtime"))
  sendEvent(name: "hitRtime", value: device.currentValue("hitQtime"))
  sendEvent(name: "hitQtime", value: device.currentValue("hitPtime"))
  sendEvent(name: "hitPtime", value: device.currentValue("hitOtime"))
  sendEvent(name: "hitOtime", value: device.currentValue("hitNtime"))
  sendEvent(name: "hitNtime", value: device.currentValue("hitMtime"))
  sendEvent(name: "hitMtime", value: device.currentValue("hitLtime"))
  sendEvent(name: "hitLtime", value: device.currentValue("hitKtime"))
  sendEvent(name: "hitKtime", value: device.currentValue("hitJtime"))
  sendEvent(name: "hitJtime", value: device.currentValue("hitItime"))
  sendEvent(name: "hitItime", value: device.currentValue("hitHtime"))
  sendEvent(name: "hitHtime", value: device.currentValue("hitGtime"))
  sendEvent(name: "hitGtime", value: device.currentValue("hitFtime"))
  sendEvent(name: "hitFtime", value: device.currentValue("hitEtime"))
  sendEvent(name: "hitEtime", value: device.currentValue("hitDtime"))
  sendEvent(name: "hitDtime", value: device.currentValue("hitCtime"))
  sendEvent(name: "hitCtime", value: device.currentValue("hitBtime"))
  sendEvent(name: "hitBtime", value: device.currentValue("hitAtime"))
  sendEvent(name: "hitAtime", value: device.currentValue("hit9time"))
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