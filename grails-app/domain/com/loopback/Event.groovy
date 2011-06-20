package com.loopback

class Event {

    String name

    static hasMany = [presentations: Presentation]

    static constraints = {
        name blank: false, maxSize: 40, validator: {val, obj->
           val.size() >= 4
        }
    }
}
