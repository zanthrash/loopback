package com.loopback

class Speaker {

    User user
    String firstName
    String lastName
    String bio

    static hasMany = [presentations: Presentation]

    static constraints = {
    }


    def getFullName() {
        "${firstName} ${lastName}".toString()
    }
}
