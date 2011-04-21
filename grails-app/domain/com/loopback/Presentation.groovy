package com.loopback

class Presentation {

    static belongsTo = [speaker:Speaker]
    static hasMany = [comments: Comment]
    String title


    static constraints = {
        title nullable: false, blank: false
    }
}
