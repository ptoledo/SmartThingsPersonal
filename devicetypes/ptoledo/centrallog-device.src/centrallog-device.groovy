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
        attribute "addEvent", "string"
        attribute "cleaning", "string"
        // Resets the state of the device to empty
        command "clear"
        // Allows to store a new event
		command "addEvent", ["string", "string"]
        // Reporting events
        // Reports the last ocurrence of an event from #1 of type #2 as timestamp
        // Reports 0 if there is not
        command "getLastEvent", ["string", "string"]
        // Reports the position of the last ocurrence of an event from #1 of type #2 as timestamp
        // among events of type #2
        // Reports 0 if there is not
        command "getLastEventPosition", ["string", "string"]
        command "toWrapper"
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
    state.sem1 = 1
    sendEvent(name: "cleaning", value: "cleaning")
    sendEvent(name: "hit0name", value: "", displayed: false)
    sendEvent(name: "hit0type", value: "", displayed: false)
    sendEvent(name: "hit0time", value:  0, displayed: false)
    sendEvent(name: "hit1name", value: "", displayed: false)
    sendEvent(name: "hit1type", value: "", displayed: false)
    sendEvent(name: "hit1time", value:  0, displayed: false)
    sendEvent(name: "hit2name", value: "", displayed: false)
    sendEvent(name: "hit2type", value: "", displayed: false)
    sendEvent(name: "hit2time", value:  0, displayed: false)
    sendEvent(name: "hit3name", value: "", displayed: false)
    sendEvent(name: "hit3type", value: "", displayed: false)
    sendEvent(name: "hit3time", value:  0, displayed: false)
    sendEvent(name: "hit4name", value: "", displayed: false)
    sendEvent(name: "hit4type", value: "", displayed: false)
    sendEvent(name: "hit4time", value:  0, displayed: false)
    sendEvent(name: "hit5name", value: "", displayed: false)
    sendEvent(name: "hit5type", value: "", displayed: false)
    sendEvent(name: "hit5time", value:  0, displayed: false)
    sendEvent(name: "hit6name", value: "", displayed: false)
    sendEvent(name: "hit6type", value: "", displayed: false)
    sendEvent(name: "hit6time", value:  0, displayed: false)
    sendEvent(name: "hit7name", value: "", displayed: false)
    sendEvent(name: "hit7type", value: "", displayed: false)
    sendEvent(name: "hit7time", value:  0, displayed: false)
    sendEvent(name: "hit8name", value: "", displayed: false)
    sendEvent(name: "hit8type", value: "", displayed: false)
    sendEvent(name: "hit8time", value:  0, displayed: false)
    sendEvent(name: "hit9name", value: "", displayed: false)
    sendEvent(name: "hit9type", value: "", displayed: false)
    sendEvent(name: "hit9time", value:  0, displayed: false)
    sendEvent(name: "hitAname", value: "", displayed: false)
    sendEvent(name: "hitAtype", value: "", displayed: false)
    sendEvent(name: "hitAtime", value:  0, displayed: false)
    sendEvent(name: "hitBname", value: "", displayed: false)
    sendEvent(name: "hitBtype", value: "", displayed: false)
    sendEvent(name: "hitBtime", value:  0, displayed: false)
    sendEvent(name: "hitCname", value: "", displayed: false)
    sendEvent(name: "hitCtype", value: "", displayed: false)
    sendEvent(name: "hitCtime", value:  0, displayed: false)
    sendEvent(name: "hitDname", value: "", displayed: false)
    sendEvent(name: "hitDtype", value: "", displayed: false)
    sendEvent(name: "hitDtime", value:  0, displayed: false)
    sendEvent(name: "hitEname", value: "", displayed: false)
    sendEvent(name: "hitEtype", value: "", displayed: false)
    sendEvent(name: "hitEtime", value:  0, displayed: false)
    sendEvent(name: "hitFname", value: "", displayed: false)
    sendEvent(name: "hitFtype", value: "", displayed: false)
    sendEvent(name: "hitFtime", value:  0, displayed: false)
    sendEvent(name: "hitGname", value: "", displayed: false)
    sendEvent(name: "hitGtype", value: "", displayed: false)
    sendEvent(name: "hitGtime", value:  0, displayed: false)
    sendEvent(name: "hitHname", value: "", displayed: false)
    sendEvent(name: "hitHtype", value: "", displayed: false)
    sendEvent(name: "hitHtime", value:  0, displayed: false)
    sendEvent(name: "hitIname", value: "", displayed: false)
    sendEvent(name: "hitItype", value: "", displayed: false)
    sendEvent(name: "hitItime", value:  0, displayed: false)
    sendEvent(name: "hitJname", value: "", displayed: false)
    sendEvent(name: "hitJtype", value: "", displayed: false)
    sendEvent(name: "hitJtime", value:  0, displayed: false)
    sendEvent(name: "hitKname", value: "", displayed: false)
    sendEvent(name: "hitKtype", value: "", displayed: false)
    sendEvent(name: "hitKtime", value:  0, displayed: false)
    sendEvent(name: "hitLname", value: "", displayed: false)
    sendEvent(name: "hitLtype", value: "", displayed: false)
    sendEvent(name: "hitLtime", value:  0, displayed: false)
    sendEvent(name: "hitMname", value: "", displayed: false)
    sendEvent(name: "hitMtype", value: "", displayed: false)
    sendEvent(name: "hitMtime", value:  0, displayed: false)
    sendEvent(name: "hitNname", value: "", displayed: false)
    sendEvent(name: "hitNtype", value: "", displayed: false)
    sendEvent(name: "hitNtime", value:  0, displayed: false)
    sendEvent(name: "hitOname", value: "", displayed: false)
    sendEvent(name: "hitOtype", value: "", displayed: false)
    sendEvent(name: "hitOtime", value:  0, displayed: false)
    sendEvent(name: "hitPname", value: "", displayed: false)
    sendEvent(name: "hitPtype", value: "", displayed: false)
    sendEvent(name: "hitPtime", value:  0, displayed: false)
    sendEvent(name: "hitQname", value: "", displayed: false)
    sendEvent(name: "hitQtype", value: "", displayed: false)
    sendEvent(name: "hitQtime", value:  0, displayed: false)
    sendEvent(name: "hitRname", value: "", displayed: false)
    sendEvent(name: "hitRtype", value: "", displayed: false)
    sendEvent(name: "hitRtime", value:  0, displayed: false)
    sendEvent(name: "hitSname", value: "", displayed: false)
    sendEvent(name: "hitStype", value: "", displayed: false)
    sendEvent(name: "hitStime", value:  0, displayed: false)
    sendEvent(name: "hitTname", value: "", displayed: false)
    sendEvent(name: "hitTtype", value: "", displayed: false)
    sendEvent(name: "hitTtime", value:  0, displayed: false)
    sendEvent(name: "cleaning", value: "ready")
    state.buff001 = null
    state.sem1 = 0
}

// Adding event to the log
def addEvent(theName, theType) {
  // Checking sempahote
  if (state.sem1 == 1){
    runIn(1, "addEvent", ["theName": theName, "theType": theType])
    log.debug "semaphoreTaken"
  } else {
    // Taking semaphore
    state.sem1 = 1
    // Displacing data on the array
    sendEvent(name: "hitTname", value: device.currentValue("hitSname"), displayed: false)
    sendEvent(name: "hitSname", value: device.currentValue("hitRname"), displayed: false)
    sendEvent(name: "hitRname", value: device.currentValue("hitQname"), displayed: false)
    sendEvent(name: "hitQname", value: device.currentValue("hitPname"), displayed: false)
    sendEvent(name: "hitPname", value: device.currentValue("hitOname"), displayed: false)
    sendEvent(name: "hitOname", value: device.currentValue("hitNname"), displayed: false)
    sendEvent(name: "hitNname", value: device.currentValue("hitMname"), displayed: false)
    sendEvent(name: "hitMname", value: device.currentValue("hitLname"), displayed: false)
    sendEvent(name: "hitLname", value: device.currentValue("hitKname"), displayed: false)
    sendEvent(name: "hitKname", value: device.currentValue("hitJname"), displayed: false)
    sendEvent(name: "hitJname", value: device.currentValue("hitIname"), displayed: false)
    sendEvent(name: "hitIname", value: device.currentValue("hitHname"), displayed: false)
    sendEvent(name: "hitHname", value: device.currentValue("hitGname"), displayed: false)
    sendEvent(name: "hitGname", value: device.currentValue("hitFname"), displayed: false)
    sendEvent(name: "hitFname", value: device.currentValue("hitEname"), displayed: false)
    sendEvent(name: "hitEname", value: device.currentValue("hitDname"), displayed: false)
    sendEvent(name: "hitDname", value: device.currentValue("hitCname"), displayed: false)
    sendEvent(name: "hitCname", value: device.currentValue("hitBname"), displayed: false)
    sendEvent(name: "hitBname", value: device.currentValue("hitAname"), displayed: false)
    sendEvent(name: "hitAname", value: device.currentValue("hit9name"), displayed: false)
    sendEvent(name: "hit9name", value: device.currentValue("hit8name"), displayed: false)
    sendEvent(name: "hit8name", value: device.currentValue("hit7name"), displayed: false)
    sendEvent(name: "hit7name", value: device.currentValue("hit6name"), displayed: false)
    sendEvent(name: "hit6name", value: device.currentValue("hit5name"), displayed: false)
    sendEvent(name: "hit5name", value: device.currentValue("hit4name"), displayed: false)
    sendEvent(name: "hit4name", value: device.currentValue("hit3name"), displayed: false)
    sendEvent(name: "hit3name", value: device.currentValue("hit2name"), displayed: false)
    sendEvent(name: "hit2name", value: device.currentValue("hit1name"), displayed: false)
    sendEvent(name: "hit1name", value: device.currentValue("hit0name"), displayed: false)
    sendEvent(name: "hit0name", value: theName, displayed: false)
    sendEvent(name: "hitTtype", value: device.currentValue("hitStype"), displayed: false)
    sendEvent(name: "hitStype", value: device.currentValue("hitRtype"), displayed: false)
    sendEvent(name: "hitRtype", value: device.currentValue("hitQtype"), displayed: false)
    sendEvent(name: "hitQtype", value: device.currentValue("hitPtype"), displayed: false)
    sendEvent(name: "hitPtype", value: device.currentValue("hitOtype"), displayed: false)
    sendEvent(name: "hitOtype", value: device.currentValue("hitNtype"), displayed: false)
    sendEvent(name: "hitNtype", value: device.currentValue("hitMtype"), displayed: false)
    sendEvent(name: "hitMtype", value: device.currentValue("hitLtype"), displayed: false)
    sendEvent(name: "hitLtype", value: device.currentValue("hitKtype"), displayed: false)
    sendEvent(name: "hitKtype", value: device.currentValue("hitJtype"), displayed: false)
    sendEvent(name: "hitJtype", value: device.currentValue("hitItype"), displayed: false)
    sendEvent(name: "hitItype", value: device.currentValue("hitHtype"), displayed: false)
    sendEvent(name: "hitHtype", value: device.currentValue("hitGtype"), displayed: false)
    sendEvent(name: "hitGtype", value: device.currentValue("hitFtype"), displayed: false)
    sendEvent(name: "hitFtype", value: device.currentValue("hitEtype"), displayed: false)
    sendEvent(name: "hitEtype", value: device.currentValue("hitDtype"), displayed: false)
    sendEvent(name: "hitDtype", value: device.currentValue("hitCtype"), displayed: false)
    sendEvent(name: "hitCtype", value: device.currentValue("hitBtype"), displayed: false)
    sendEvent(name: "hitBtype", value: device.currentValue("hitAtype"), displayed: false)
    sendEvent(name: "hitAtype", value: device.currentValue("hit9type"), displayed: false)
    sendEvent(name: "hit9type", value: device.currentValue("hit8type"), displayed: false)
    sendEvent(name: "hit8type", value: device.currentValue("hit7type"), displayed: false)
    sendEvent(name: "hit7type", value: device.currentValue("hit6type"), displayed: false)
    sendEvent(name: "hit6type", value: device.currentValue("hit5type"), displayed: false)
    sendEvent(name: "hit5type", value: device.currentValue("hit4type"), displayed: false)
    sendEvent(name: "hit4type", value: device.currentValue("hit3type"), displayed: false)
    sendEvent(name: "hit3type", value: device.currentValue("hit2type"), displayed: false)
    sendEvent(name: "hit2type", value: device.currentValue("hit1type"), displayed: false)
    sendEvent(name: "hit1type", value: device.currentValue("hit0type"), displayed: false)
    sendEvent(name: "hit0type", value: theType, displayed: false)
    sendEvent(name: "hitTtime", value: device.currentValue("hitStime"), displayed: false)
    sendEvent(name: "hitStime", value: device.currentValue("hitRtime"), displayed: false)
    sendEvent(name: "hitRtime", value: device.currentValue("hitQtime"), displayed: false)
    sendEvent(name: "hitQtime", value: device.currentValue("hitPtime"), displayed: false)
    sendEvent(name: "hitPtime", value: device.currentValue("hitOtime"), displayed: false)
    sendEvent(name: "hitOtime", value: device.currentValue("hitNtime"), displayed: false)
    sendEvent(name: "hitNtime", value: device.currentValue("hitMtime"), displayed: false)
    sendEvent(name: "hitMtime", value: device.currentValue("hitLtime"), displayed: false)
    sendEvent(name: "hitLtime", value: device.currentValue("hitKtime"), displayed: false)
    sendEvent(name: "hitKtime", value: device.currentValue("hitJtime"), displayed: false)
    sendEvent(name: "hitJtime", value: device.currentValue("hitItime"), displayed: false)
    sendEvent(name: "hitItime", value: device.currentValue("hitHtime"), displayed: false)
    sendEvent(name: "hitHtime", value: device.currentValue("hitGtime"), displayed: false)
    sendEvent(name: "hitGtime", value: device.currentValue("hitFtime"), displayed: false)
    sendEvent(name: "hitFtime", value: device.currentValue("hitEtime"), displayed: false)
    sendEvent(name: "hitEtime", value: device.currentValue("hitDtime"), displayed: false)
    sendEvent(name: "hitDtime", value: device.currentValue("hitCtime"), displayed: false)
    sendEvent(name: "hitCtime", value: device.currentValue("hitBtime"), displayed: false)
    sendEvent(name: "hitBtime", value: device.currentValue("hitAtime"), displayed: false)
    sendEvent(name: "hitAtime", value: device.currentValue("hit9time"), displayed: false)
    sendEvent(name: "hit9time", value: device.currentValue("hit8time"), displayed: false)
    sendEvent(name: "hit8time", value: device.currentValue("hit7time"), displayed: false)
    sendEvent(name: "hit7time", value: device.currentValue("hit6time"), displayed: false)
    sendEvent(name: "hit6time", value: device.currentValue("hit5time"), displayed: false)
    sendEvent(name: "hit5time", value: device.currentValue("hit4time"), displayed: false)
    sendEvent(name: "hit4time", value: device.currentValue("hit3time"), displayed: false)
    sendEvent(name: "hit3time", value: device.currentValue("hit2time"), displayed: false)
    sendEvent(name: "hit2time", value: device.currentValue("hit1time"), displayed: false)
    sendEvent(name: "hit1time", value: device.currentValue("hit0time"), displayed: false)
    sendEvent(name: "hit0time", value: now(), displayed: false)
    // Clearing getLastEventPosition buffer
    if(state.buff001 != null){
      if(state.buff001[theType] != null){
        state.buff001[theType] = null
      }
    }
    // Reporting
    sendEvent(name: "addEvent", value: "(${theName}, ${theType}) at ${now()}")
    log.debug "CentralLog.addEvent${device.currentValue("addEvent")}"
    // Freeing semaphore
    state.sem1 = 0
  }
}

def getId(i){
 if(i<0 || i>29){
    return "ERROR"
  }
  i+=48
  i+=(i>57)?7:0
  return (char) i
}

def getName(id){
  if(getId(id) == "ERROR"){
    return "ERROR"
  }
  return device.currentValue("hit${getId(id)}name")
}

def getType(id){
  if(getId(id) == "ERROR"){
    return "ERROR"
  }
  return device.currentValue("hit${getId(id)}type")
}

def getTime(id){
  if(getId(id) == "ERROR"){
    return "ERROR"
  }
  return device.currentValue("hit${getId(id)}time")
}

// Reporting events
// Reports the last ocurrence of an event from #1 of type #2 as timestamp
// Reports 0 if there is not
def getLastEvent(theName, theType){
  def buffer = "Looking for name: ${theName} with type ${theType}\n"
  for(int i = 0; i<30; i++){
    if(getName(i) == theName && getType(i) == theType){
      return getTime(i)
    }
  }
  return 0;
}

def toWrapper(){
  //clear()
  getLastEventPosition("04e91058-f833-4bd8-8598-0017e670d511", "active")
  //log.debug getLastEventPosition("2e81bdc0-1799-4a59-b5c1-ec3bdd2aeae5", "open")
}

// Reports the position of the last ocurrence of an event from #1 of type #2 as timestamp
// among events of type #2
// Reports 0 if there is not
def getLastEventPosition(theName, theType){
  if(state.buff001 == null || state.buff001[theType] == null){
    // Checking sempahore
    while (state.sem1 == 1){
      log.debug "semaphoreTaken"
    }
    // Taking semaphore
    state.sem1 = 1
    // Storing data
    def list = [:]
    int counter = 0;
    for(int i=0; i<30; i++){
      if(getType(i) == theType){
        list[counter] = [:]
        list[counter].name = getName(i)
        list[counter].time = getTime(i)
        counter++
      }
    }
    // Freeing semaphore
    state.sem1 = 0
    // Processing
    int t = counter
    for(; counter<30; counter++){
      list[counter] = null;
    }
    for(int i=0; i<t; i++){
      if(list.get(i) == null){
        continue
      }
      for(int j=i+1; j<t; j++){
        if(list[j] == null){
          continue
        }
        if(list[i].name == list[j].name){
          list[j] = null
        }
      }
      for(int j=0; j<t; j++){
        if(list[j] != null){
          continue
        }
        int k = j+1
        while(list[k] == null && k<t){
          k++
        }
        if(k>=t || list[k] == null){
          break
        }
        list[j] = list[k]
        list[k] = null
      }
    }
    // Reporting
    if(state.buff001 == null){
      state.buff001 = [:]
    }
    state.parser = list
    state.buff001[theType] = state.parser
  } else {
    log.debug "From buffer"
  }
  // Returning result
  def buffer = "\nLooking for name: ${theName} with type ${theType}"
  int toReturn = -1;
  for(int i=0; (i<30 && toReturn<0); i++){
    if(state.buff001[theType]["${i}"] == null){
      i = 30
      continue
    }
    if(state.buff001[theType]["${i}"].name == theName){
      toReturn = i
    }
  }
  for(int i=0; i<30; i++){
    if(state.buff001[theType]["${i}"] == null){
      break
    }
    buffer=buffer+"\n"+"${i} - ${state.buff001[theType]["${i}"].name} - ${state.buff001[theType]["${i}"].time}"
  }
  buffer=buffer+"\nEvent located at position ${toReturn}"
  log.debug buffer
  return toReturn
}
       
// Parse events into attributes
def parse(String description) {
}