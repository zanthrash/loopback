package com.loopback

class Presentation {

    static belongsTo = Speaker
    static hasMany = [comments: Comment, speakers:Speaker]
    String title
    String accessCode


    static constraints = {
        title nullable: false, blank: false
        accessCode nullable: false, blank: false
    }


}
