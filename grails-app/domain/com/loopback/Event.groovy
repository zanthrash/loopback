package com.loopback

class Event {

    String name

    static hasMany = [presentations: Presentation]

    static constraints = {
        name nullable: false, blank: false, maxSize: 40
    }
}
