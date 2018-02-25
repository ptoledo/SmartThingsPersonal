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
  definition (name: "CentralLog - BulbGroup Device", namespace: "smartthings", author: "Pedro Toledo") {
    // Capabilities
    capability "Color Control"
    capability "Color Temperature"
    capability "Switch"
    capability "Switch Level"
    capability "Refresh"
    
    // Attributes
    attribute "lastChange", "number"
    // Alexa parameters (lastChange 0)
    attribute "alexaStatus", "number"
    attribute "alexaHue", "number"
    attribute "alexaSaturation", "number"
    attribute "alexaLevel", "number"
    attribute "alexaTemperature", "number"
    // Group parameters (lastChange 1)
    attribute "groupStatus", "number"
    attribute "groupHue", "number"
    attribute "groupSaturation", "number"
    attribute "groupLevel", "number"
    attribute "groupTemperature", "number"
    // Inspector parameters (lastChange 2)
    attribute "inspectorStatus", "number"
    // App parameters (lastChange 3)
    attribute "appStatus", "number"
    attribute "appHue", "number"
    attribute "appSaturation", "number"
    attribute "appLevel", "number"
    attribute "appTemperature", "number"
    // Enbled setting
    attribute "settingEnabled", "string"
    attribute "settingController", "enum", ["Alexa", "Group", "Inspector", "App"]
    
    // Commands
    command "inspectorOn"
    command "inspectorOff"
    command "clear"
    command "appOn"
    command "appOff"
    command "appSetLevel", ["number"]
    command "appSetColorTemperature", ["number"]
    command "appSetColor", ["number"]
  }
  
  tiles (scale: 2) {
    multiAttributeTile(name:"switch", type: "generic", width: 6, height: 4, canChangeIcon: true) {
      tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
        attributeState "on", label:'${name}', action:"appOff", icon:"st.lights.multi-light-bulb-on", backgroundColor:"#00a0dc"//, nextState:"turningOff"
        attributeState "off", label:'${name}', action:"appOn", icon:"st.lights.multi-light-bulb-off", backgroundColor:"#ffffff"//, nextState:"turningOn"
        //attributeState "turningOn", label:'${name}', action:"appOn", icon:"st.lights.multi-light-bulb-on", backgroundColor:"#00a0dc", nextState:"turningOff"
        //attributeState "turningOff", label:'${name}', action:"appOff", icon:"st.lights.multi-light-bulb-off", backgroundColor:"#ffffff", nextState:"turningOn"
      }
      tileAttribute("device.settingController", key: "SECONDARY_CONTROL") {
        attributeState "settingController", label: 'Controller: ${currentValue}'
      }
      tileAttribute("device.color", key: "COLOR_CONTROL") {
        attributeState "color", action:"appSetColor"
      }
    }
    standardTile("level", "device.level", width: 2, height: 1) {
      state "level", label: 'Level:\n${currentValue}%'
    }    
    controlTile("appLevelSlider", "device.appLevel", "slider", height: 1, width: 2, range:"(0..100)") {
      state "appLevel", action: "appSetLevel"
    }
    standardTile("hue", "device.hue", width: 2, height: 1) {
      state "hue", label: 'Hue:\n${currentValue}'
    }
    standardTile("colorTemp", "device.colorTemp", width: 2, height: 1) {
      state "colorTemp", label: 'Temp:\n${currentValue}'
    }
    controlTile("appTemperatureSlider", "device.appTemperature", "slider", height: 1, width: 2, range:"(2700..9000)") {
      state "appTemperature", action: "appSetColorTemperature"
    }
    standardTile("saturation", "device.saturation", width: 2, height: 1) {
      state "saturation", label: 'Saturation:\n${currentValue}'
    }
    standardTile("settingEnabled", "device.settingEnabled", width: 2, height: 1) {
      state "settingEnabled", label: 'Setting:\n${currentValue}'
    }
    standardTile("padding", "", width: 3, height: 1) {
      state "", label: ' '
    }
    standardTile("clearing", "device.settingController") {
      state "Alexa"    , label: "Taken by Alexa", backgroundColor: "#00a0dc", action: "clear"
      state "App"      , label: "Clear"         , backgroundColor: "#ffffff", action: "clear"
      state "Group"    , label: "Clear"         , backgroundColor: "#ffffff", action: "clear"
      state "Inspector", label: "Clear"         , backgroundColor: "#ffffff", action: "clear"
    }
  }
  
  preferences {
    input name: "bulbType", type: "enum",              title: "Bulb type", options: ["Color", "White"], description: "Set the tipe of bulbs to be controlled", required: true
    input name: "bulb0",    type: "capability.switch", title: "Bulb 0", description: "Set the bulb 0 to control", required: false, multiple: false
    input name: "bulb1",    type: "capability.switch", title: "Bulb 1", description: "Set the bulb 1 to control", required: false, multiple: false
    input name: "bulb2",    type: "capability.switch", title: "Bulb 2", description: "Set the bulb 2 to control", required: false, multiple: false
    input name: "bulb3",    type: "capability.switch", title: "Bulb 3", description: "Set the bulb 3 to control", required: false, multiple: false
  }
  
  simulator {
    // TODO: define status and reply messages here
  }
}

// Global status calculation
def update() {
  def toLevel = null
  def toColor = null
  def toStatus = null
  def toTemperature = null
  def lastChange = device.currentValue("lastChange")
  
  // Processing request
  if (lastChange >= 0 && lastChange < 10) {
    // Alexa control, overwrites all
    sendEvent(name: "settingController", value: "Alexa")
    if (lastChange == 0 || lastChange == 1) {
      toStatus = device.currentValue("alexaStatus")
    } else if (lastChange == 2) {
      toLevel = device.currentValue("alexaLevel")
    } else if (lastChange == 3) {
      toTemperature = device.currentValue("alexaTemperature")
    } else if (lastChange == 4) {
      toColor = [:]
      toColor.hue = device.currentValue("alexaHue")
      toColor.saturation = device.currentValue("alexaSaturation")
    }
  } else if (lastChange < 20) {
    // Group control
    if (device.currentValue("settingController") != "Alexa") {
      lastChange = lastChange-10
      sendEvent(name: "settingController", value: "Group")
      if (lastChange == 0 || lastChange == 1) {
        toStatus = device.currentValue("groupStatus")
      } else if (lastChange == 2) {
        toLevel = device.currentValue("groupLevel")
      } else if (lastChange == 3) {
        toTemperature = device.currentValue("groupTemperature")
      } else if (lastChange == 4) {
        toColor = [:]
        toColor.hue = device.currentValue("groupHue")
        toColor.saturation = device.currentValue("groupSaturation")
      }
    }
  } else if (lastChange < 30) {
    // Inspector control
    if (device.currentValue("settingController") != "Alexa") {
      lastChange = lastChange - 20
      sendEvent(name: "settingController", value: "Inspector")
      if (lastChange == 0 || lastChange == 1) {
        toStatus = device.currentValue("inspectorStatus")
      }
    }
  } else if (lastChange < 40) {
    // App control
    lastChange = lastChange - 30
    sendEvent(name: "settingController", value: "App")
    if (lastChange == 0 || lastChange == 1) {
      toStatus = device.currentValue("appStatus")
    } else if (lastChange == 2) {
      toLevel = device.currentValue("appLevel")
    } else if (lastChange == 3) {
      toTemperature = device.currentValue("appTemperature")
    } else if (lastChange == 4) {
      toColor = [:]
      toColor.hue = device.currentValue("appHue")
      toColor.saturation = device.currentValue("appSaturation")
    }
  }

  // Processing change
  def toSend = null
  if (toStatus != null) {
    if (toStatus == 0) {
      toSend = [name: "switch", value: "off"]
    } else {
      toSend = [name: "switch", value: "on"]
    }
  }
  if (toLevel != null) {
    toSend = [name: "level", value: toLevel]
  }
  if (toTemperature != null) {
    toSend = [name: "colorTemp", value: toTemperature]
    sendEvent(name: "settingEnabled", value: "Temperature", displayed: false)
  }
  if (toColor != null) {
    toSend = [name: "color", value: toColor]
    sendEvent(name: "settingEnabled", value: "Color", displayed: false)
    sendEvent(name: "hue", value: toColor.hue, displayed: false)
    sendEvent(name: "saturation", value: toColor.saturation, displayed: false)
  }
  if (toSend != null) {
    refreshBulbs(toSend)
  }
}

// Alexa controlling methods
def on() {
  sendEvent(name: "alexaStatus", value: 1, displayed: false)
  sendEvent(name: "lastChange", value: 0, displayed: false)
  update()
}
def off() {
  sendEvent(name: "alexaStatus", value: 0, displayed: false)
  sendEvent(name: "lastChange", value: 1, displayed: false)
  update()
}
def setLevel(level) {
  sendEvent(name: "alexaLevel", value: level, displayed: false)
  sendEvent(name: "lastChange", value: 2, displayed: false)
  update()
}
def setColorTemperature(temperature) {
  sendEvent(name: "alexaTemperature", value: temperature, displayed: false)
  sendEvent(name: "lastChange", value: 3, displayed: false)
  update()
}
def setColor(huesaturation) {
  if (bulbType == "Color") {
    sendEvent(name: "alexaHue", value: huesaturation.hue, displayed: false)
    sendEvent(name: "alexaSaturation", value: huesaturation.saturation, displayed: false)
    sendEvent(name: "lastChange", value: 4, displayed: false)
    update()
  } else {
    log.debug "ERROR: trying to set color on white bulb"
  }
}

// Group Methods
def groupOn() {
  sendEvent(name: "groupStatus", value: 1, displayed: false)
  sendEvent(name: "lastChange", value: 10, displayed: false)
  update()
}
def groupOff() {
  sendEvent(name: "groupStatus", value: 0, displayed: false)
  sendEvent(name: "lastChange", value: 11, displayed: false)
  update()
}
def groupSetLevel(level) {
  sendEvent(name: "groupLevel", value: level, displayed: false)
  sendEvent(name: "lastChange", value: 12, displayed: false)
  update()
}
def groupSetColorTemperature(temperature) {
  sendEvent(name: "groupTemperature", value: temperature, displayed: false)
  sendEvent(name: "lastChange", value: 13, displayed: false)
  update()
}
def groupSetColor(huesaturation) {
  if (bulbType == "Color") {
    sendEvent(name: "groupHue", value: huesaturation.hue, displayed: false)
    sendEvent(name: "groupSaturation", value: huesaturation.saturation, displayed: false)
    sendEvent(name: "lastChange", value: 14, displayed: false)
    update()
  } else {
    log.debug "ERROR: trying to set color on white bulb"
  }
}

// LogInspector Methods
def inspectorOn(){
  sendEvent(name: "inspectorStatus", value: 1, displayed: false)
  sendEvent(name: "lastChange", value: 20, displayed: false)
  update()
}
def inspectorOff(){
  sendEvent(name: "inspectorStatus", value: 0, displayed: false)
  sendEvent(name: "lastChange", value: 21, displayed: false)
  update()
}

// App Methods
def appOn() {
  sendEvent(name: "appStatus", value: 1, displayed: false)
  sendEvent(name: "lastChange", value: 30, displayed: false)
  update()
}
def appOff() {
  sendEvent(name: "appStatus", value: 0, displayed: false)
  sendEvent(name: "lastChange", value: 31, displayed: false)
  update()
}
def appSetLevel(level) {
  sendEvent(name: "appLevel", value: level, displayed: false)
  sendEvent(name: "lastChange", value: 32, displayed: false)
  update()
}
def appSetColorTemperature(temperature) {
  sendEvent(name: "appTemperature", value: temperature, displayed: false)
  sendEvent(name: "lastChange", value: 33, displayed: false)
  update()
}
def appSetColor(huesaturation) {
  if (bulbType == "Color") {
    sendEvent(name: "appHue", value: huesaturation.hue, displayed: false)
    sendEvent(name: "appSaturation", value: huesaturation.saturation, displayed: false)
    sendEvent(name: "lastChange", value: 34, displayed: false)
    update()
  } else {
    log.debug "ERROR: trying to set color on white bulb"
  }
}

// System calls
def clear() {
  sendEvent(name: "settingController", value: "Inspector", displayed: false)
}
private refreshBulbs(command) {
  sendEvent(command)
  if (bulb0 != null) {
    //log.debug "Refresh Bulb0"
    sendEvent(name: "refresh", value: command, data: [bulb: bulb0, name: command.name, value: command.value])
  }
  if (bulb1 != null) {
    //log.debug "Refresh Bulb1"
    sendEvent(name: "refresh", value: command, data: [bulb: bulb1, name: command.name, value: command.value])
  }
  if (bulb2 != null) {
    //log.debug "Refresh Bulb2"
    sendEvent(name: "refresh", value: command, data: [bulb: bulb2, name: command.name, value: command.value])
  }
  if (bulb3 != null) {
    //log.debug "Refresh Bulb3"
    sendEvent(name: "refresh", value: command, data: [bulb: bulb3, name: command.name, value: command.value])
  }
}

// Unsupported commands
def setHue() {
  log.debug "ERROR: 'setHue' Unsupported"
}
def setSaturation() {
  log.debug "ERROR: 'setSaturation' Unsupported"
}

// Non used methods
def parse(String description) {
}