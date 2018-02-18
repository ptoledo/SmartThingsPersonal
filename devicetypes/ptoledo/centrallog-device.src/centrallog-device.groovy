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
    // Capabilities
    // Creating the log capability to differentiate function
    capability "notification"
    
    // Attributes
    // Clear function running flag
    attribute "cleaning", "string"
    // For showing the add events processes
    attribute "addEvent", "string"
    // Tile reporting values
    attribute "hit0name", "string"
    attribute "hit1name", "string"
    attribute "hit2name", "string"
    attribute "hit3name", "string"
    attribute "hit0type", "string"
    attribute "hit1type", "string"
    attribute "hit2type", "string"
    attribute "hit3type", "string"
    attribute "hit0time", "string"
    attribute "hit1time", "string"
    attribute "hit2time", "string"
    attribute "hit3time", "string"
    // Communicating with other apps
    attribute "channel0", "number"
    attribute "channel1", "number"
    attribute "channel2", "number"
    attribute "channel3", "number"
    attribute "channel4", "number"
    attribute "channel5", "number"
    attribute "channel6", "number"
    attribute "channel7", "number"
    attribute "channel8", "number"
    attribute "channel9", "number"
    
    // Commands
    // Events Management
    // Resets the state of the device to empty
    command "clear"
    // Stores a new event
    command "addEvent", ["string", "string"]
    // Events analysis
    // Reports the last ocurrence of an event from #1 of type #2 as timestamp
    command "getLastEventTime", ["string", "string"]
    // Reports the position of the last ocurrence of an event from #1 of type #2 as timestamp among events of type #2
    command "getLastEventPosition", ["string", "string"]
    // Communication
    // Communicates the getLastEventPosition from #1 of type #2 on channel #3
    command "getLastEventPositionExternal", ["string", "string", "string"]
    // Testing
    // Wrapper for testing propposes
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
      state "hit3time", label: '${currentValue}', action: "clear"
    }
  }
  
  simulator {
    // TODO: define status and reply messages here
  }
}

// Clears the current list stack
def clear() {
  // Taking mutex: clear rules over all, no check required
  state.mutex001 = 1
  // Setting flag for tile display
  sendEvent(name: "cleaning", value: "cleaning")
  log.debug "CentralLog.clear()"
  // Clearing tiles values
  sendEvent(name: "hit0name", value: "", displayed: false)
  sendEvent(name: "hit0type", value: "", displayed: false)
  sendEvent(name: "hit0time", value: "", displayed: false)
  sendEvent(name: "hit1name", value: "", displayed: false)
  sendEvent(name: "hit1type", value: "", displayed: false)
  sendEvent(name: "hit1time", value: "", displayed: false)
  sendEvent(name: "hit2name", value: "", displayed: false)
  sendEvent(name: "hit2type", value: "", displayed: false)
  sendEvent(name: "hit2time", value: "", displayed: false)
  sendEvent(name: "hit3name", value: "", displayed: false)
  sendEvent(name: "hit3type", value: "", displayed: false)
  sendEvent(name: "hit3time", value: "", displayed: false)
  // Clearing the events stored
  state.events = [:]
  // Clearing calculation buffers
  state.buff001 = [:]
  state.buff002 = [:]
  // Unstetting flag for tile display
  sendEvent(name: "cleaning", value: "ready")
  // Liberating mutex
  state.mutex001 = 0
}

// Adding event to the log
def addEvent(theName, theType) {
  // Checking mutex
  if (state.mutex001 == 1){
    runIn(1, "addEvent", ["theName": theName, "theType": theType])
    log.debug "mutex001 is taken, reruning in 1[s]"
  } else {
    // Taking mutex
    state.mutex001 = 1
    // Displacing data on the array
    for(int i=42; i>0; i--){
      if(state.events["${i-1}"] != null){
        state.events["${i}"] = state.events["${i-1}"]
      }
    }
    // Storing new event
    state.events["0"] = [:]
    state.events["0"].name = theName
    state.events["0"].type = theType
    state.events["0"].time = now()
    // Reporting to tiles
    for(int i=0; i<4; i++){
      if(state.events["${i}"] != null){
        sendEvent(name: "hit${i}name", value: state.events["${i}"].get("name", ""), displayed: false)
        sendEvent(name: "hit${i}type", value: state.events["${i}"].get("type", ""), displayed: false)
        sendEvent(name: "hit${i}time", value: state.events["${i}"].get("time", ""), displayed: false)
      } else {
        i = 4;
      }
    }
    // Clearing getLastEventPosition buffer
    // getEventsList
    if(state.buff001 != null){
      state.buff001[theType] = null
    }
    // getEventsList
    if(state.buff002 != null){
      state.buff002[theType] = null
    }
    // Reporting
    sendEvent(name: "notification.deviceNotification", value: "CentralLog.addEvent(${state.events["0"].name}, ${state.events["0"].type}) at ${state.events["0"].time}")
    // Freeing mutex
    state.mutex001 = 0
  }
}

def deviceNotification(){
}

def printEvents(theEvents){
  String toPrint = ""
  if(theEvents == null){
    toPrint = toPrint+"No events to print"
  } else {
    int i = 0;
    while(theEvents["${i}"] != null){
      toPrint = toPrint+"\nTime: ${theEvents["${i}"].time} Event: ${theEvents["${i}"].type} Name: ${theEvents["${i}"].name}"
      i++
    }
    return toPrint
  }
}

def mapUnique(theMap, theKey){
  if(theMap == null){
    return [:]
  }
  def theMapInternal = theMap
  int theMapSize = theMapInternal.size()
  for(int i=0; i<theMapSize; i++){
    for(int j=i+1; j<theMapSize; j++){
      if(theMapInternal["${i}"] != null && theMapInternal["${j}"] != null){ 
        if(theMapInternal["${i}"][theKey] == theMapInternal["${j}"][theKey]){
          theMapInternal = theMapInternal.findAll{it.key != "${j}"}
        }
      }
    }
  }
  for(int i=0; i<theMapSize; i++){
    if(theMapInternal["${i}"] == null){
      for(int j=i+1;j<theMapSize; j++){
        if(theMapInternal["${j}"] != null){
          theMapInternal["${i}"] = theMapInternal["${j}"]
          theMapInternal = theMapInternal.findAll{it.key != "${j}"}
        }
      }
    }
    if(theMapInternal["${i}"] == null){
      i = theMapSize
    }
  }
  return theMapInternal
}

def getEventsList(theType){
  // Checking mutex
  if (state.mutex001 == 1){
    runIn(1, "getEventsList", ["theType": theType])
    log.debug "mutex001 is taken, reruning in 1[s]"
  } else {
    if(!(state.buff001 != null && state.buff001[theType] != null)){
      // Taking mutex
      state.mutex001 = 1
      // Getting info
      def theSource = state.events
      // Freeing the mutex
      state.mutex001 = 0
      // Process
      def theReturn = [:]
      int counter = 0
      for(int i=0;i<42;i++){
        if(theSource["${i}"] == null){
          i=42
          continue
        }
        if(theSource["${i}"].type == theType){
          theReturn["${counter++}"] = theSource["${i}"]
        }
      }
      // Reporting
      state.buff001[theType] = theReturn
    }
    return state.buff001[theType]
  }
}

// Reports the last aparition of an event from #1 of type #2
def getLastEventTime(theName, theType){
  def events = getEventsList(theType)
  for(int i=0; i<events.size(); i++){
    if(events["${i}"].name == theName){
      return events["${i}"].time
    }
  }
  return 0;
}

// Reports the last position of an event from #1 of type #2
def getLastEventPosition(theName, theType){
  if(!(state.buff002 != null && state.buff002[theType] != null)){
    state.buff002[theType] = mapUnique(getEventsList(theType), "name")
  }
  def events = state.buff002[theType]
  for(int i=0; i<events.size(); i++){
    if(events["${i}"].name == theName){
      return i
    }
  }
  return -1;
}

def getLastEventPositionExternal(theName, theType, theChannel){
  sendEvent(name: "channel${theChannel}", value: getLastEventPosition(theName, theType))
}

// Parse events into attributes
def parse(String description) {
}