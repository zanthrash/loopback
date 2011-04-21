package com.loopback

class Event {

    String name

    static hasMany = [speakers: Speaker]

    static constraints = {
        name nullable: false, blank: false, maxSize: 40
    }
}
