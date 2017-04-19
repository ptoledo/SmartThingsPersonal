/**
 *  Light Control
 *
 *  Copyright 2016 Pedro Toledo
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
    name: "Light Control",
    namespace: "ptoledo",
    author: "Pedro Toledo",
    description: "To control the lights on/off according to presence detection",
    category: "SmartThings Labs",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    oauth: true) {
    appSetting "accessToken"
}

preferences {
  page(name: "Configure the areas", install: true) {
    section("Set the information flag switches") {
      paragraph("Select your switches to communicate presence")
      input "presenceSwitchLiving", "capability.switch", title: "Pick your Living switch"
      input "presenceSwitchCocina", "capability.switch", title: "Pick your Cocina switch"
      input "presenceSwitchPasillo", "capability.switch", title: "Pick your Pasillo switch"
      input "presenceSwitchEstudio", "capability.switch", title: "Pick your Estudio switch"
      input "presenceSwitchBanoi", "capability.switch", title: "Pick your Baño Invitado switch"
      input "presenceSwitchDormitorio", "capability.switch", title: "Pick your Dormitorio switch"
      input "presenceSwitchCloset", "capability.switch", title: "Pick your Closet switch"
      input "presenceSwitchBanop", "capability.switch", title: "Pick your Baño Principal switch"
    }
    section("Set the light switch for each room"){
      input "lightsLiving", "capability.switch", title: "Pick your Living lights", multiple: true, required: false
      input "lightsCocina", "capability.switch", title: "Pick your Cocina lights", multiple: true, required: false
      input "lightsPasillo", "capability.switch", title: "Pick your Pasillo lights", multiple: true, required: false
      input "lightsEstudio", "capability.switch", title: "Pick your Estudio lights", multiple: true, required: false
      input "lightsBanoi", "capability.switch", title: "Pick your Baño Invitado lights", multiple: true, required: false
      input "lightsDormitorio", "capability.switch", title: "Pick your Dormitorio lights", multiple: true, required: false
      input "lightsCloset", "capability.switch", title: "Pick your Closet lights", multiple: true, required: false
      input "lightsBanop", "capability.switch", title: "Pick your Baño Principal lights", multiple: true, required: false

    }
    section("Set the dimm light switch for each room"){
      input "lightsDimmMode", "mode", title: "Pick your mode for dimm activation", multiple: true, required: false
      input "lightsDimmLiving", "capability.switch", title: "Pick your Living lights", multiple: true, required: false
      input "lightsDimmCocina", "capability.switch", title: "Pick your Cocina lights", multiple: true, required: false
      input "lightsDimmPasillo", "capability.switch", title: "Pick your Pasillo lights", multiple: true, required: false
      input "lightsDimmEstudio", "capability.switch", title: "Pick your Estudio lights", multiple: true, required: false
      input "lightsDimmBanoi", "capability.switch", title: "Pick your Baño Invitado lights", multiple: true, required: false
      input "lightsDimmDormitorio", "capability.switch", title: "Pick your Dormitorio lights", multiple: true, required: false
      input "lightsDimmCloset", "capability.switch", title: "Pick your Closet lights", multiple: true, required: false
      input "lightsDimmBanop", "capability.switch", title: "Pick your Baño Principal lights", multiple: true, required: false
    }
    section("Configuration"){
      input "offDelay", "number", title: "Set the delay to turn off a light at exiting the zone", required: true
      input "presenceSwitchOutside", "capability.switch", title: "Pick your Outside switch"
      input "lightsOutside", "capability.switch", title: "Pick your Outside event lights", multiple: true, required: false
    }
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
  subscribe(presenceSwitchLiving, "switch", lightsLivingHandler)
  subscribe(presenceSwitchCocina, "switch", lightsCocinaHandler)
  subscribe(presenceSwitchPasillo, "switch", lightsPasilloHandler)
  subscribe(presenceSwitchEstudio, "switch", lightsEstudioHandler)
  subscribe(presenceSwitchBanoi, "switch", lightsBanoiHandler)
  subscribe(presenceSwitchDormitorio, "switch", lightsDormitorioHandler)
  subscribe(presenceSwitchCloset, "switch", lightsClosetHandler)
  subscribe(presenceSwitchBanop, "switch", lightsBanopHandler)
  subscribe(presenceSwitchOutside, "switch", lightsOutsideHandler)
}

def lightsLivingHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsLiving.on()
      lightsDimmLiving.off()
    } else {
      lightsLiving.off()
      lightsDimmLiving.on()
    }
  } else {
    runIn(offDelay, offLiving)
  }
}

def offLiving() {
  if(presenceSwitchLiving.currentswitch == "off" && presenceSwitchCocina.currentswitch == "off" && presenceSwitchEntrada.currentswitch == "off"){
    lightsLiving.off()
    lightsDimmLiving.off()
  } else {
    runIn(offDelay, offLiving)
  }
}

def lightsCocinaHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsCocina.on()
      lightsDimmCocina.off()
    } else {
      lightsCocina.off()
      lightsDimmCocina.on()
    }
  } else {
    runIn(offDelay, offCocina)
  }
}

def offCocina() {
  if(presenceSwitchCocina.currentswitch == "off"){
    lightsCocina.off()
    lightsDimmCocina.off()    
  }
}

def lightsPasilloHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsPasillo.on()
      lightsDimmPasillo.off()
    } else {
      lightsPasillo.off()
      lightsDimmPasillo.on()
    }
  } else {
    runIn(offDelay, offPasillo)
  }
}

def offPasillo() {
  if(presenceSwitchPasillo.currentswitch == "off"){
    lightsPasillo.off()
    lightsDimmPasillo.off()
  } else {
    runIn(offDelay, offPasillo)
  }
}

def lightsEstudioHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsEstudio.on()
      lightsDimmEstudio.off()
    } else {
      lightsEstudio.off()
      lightsDimmEstudio.on()
    }
  } else {
    runIn(offDelay, offEstudio)
  }
}

def offEstudio() {
  if(presenceSwitchEstudio.currentswitch == "off"){
    lightsEstudio.off()
    lightsDimmEstudio.off()
  }
}

def lightsBanoiHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsBanoi.on()
      lightsDimmBanoi.off()
    } else {
      lightsBanoi.off()
      lightsDimmBanoi.on()
    }
  } else {
    runIn(offDelay, offBanoi)
  }
}

def offBanoi() {
  if(presenceSwitchBanoi.currentswitch == "off"){
    lightsBanoi.off()
    lightsDimmBanoi.off()
  }
}

def lightsDormitorioHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsDormitorio.on()
      lightsDimmDormitorio.off()
    } else {
      lightsDormitorio.off()
      lightsDimmDormitorio.on()
    }
  } else {
    runIn(offDelay, offDormitorio)
  }
}

def offDormitorio() {
  if(presenceSwitchDormitorio.currentswitch == "off"){
    lightsDormitorio.off()
    lightsDimmDormitorio.off()
  } else {
    runIn(offDelay, offDormitorio)
  }
}

def lightsClosetHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsCloset.on()
      lightsDimmCloset.off()
    } else {
      lightsCloset.off()
      lightsDimmCloset.on()
    }
  } else {
    runIn(offDelay, offCloset)
  }
}

def offCloset() {
  if(presenceSwitchCloset.currentswitch == "off"){
    lightsDimmCloset.off()
  } else {
    runIn(offDelay, offCloset)
  }
}

def lightsBanopHandler(evt) {
  if(evt.value == "on") {
    if (location.mode != lightsDimmMode) {
      lightsBanop.on()
      lightsDimmBanop.off()
    } else {
      lightsBanop.off()
      lightsDimmBanop.on()
    }
  } else {
    runIn(offDelay, offBanop)
  }
}

def offBanop() {
  if(presenceSwitchBanop.currentswitch == "off"){
    lightsBanop.off()
    lightsDimmBanop.off()
  } else {
    runIn(offDelay, offBanop)
  }
}

def lightsOutsideHandler(evt) {
  if(evt.value == "on") {
    lightsOutside.off()
  }
}
