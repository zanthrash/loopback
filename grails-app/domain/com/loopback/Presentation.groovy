package com.loopback

class Presentation {

    static hasMany = [comments: Comment]
    String event
    Speaker speaker
    Date dateCreated
    Date date
    String title
    String accessCode

    static constraints = {
        title nullable: false, blank: false
        accessCode nullable: false, blank: false
        date nullable: true
        event nullable: true
    }

    def commentCountByMember() {
        def result = [:]
        comments.each {
           result[it.clientIPAddress] = result.get(it.clientIPAddress, 0) + 1
        }

        result
    }
}
