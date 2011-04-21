package com.loopback

class Comment {

    Date dateCreated
    String text


    static constraints = {
        text nullable: false, blank:false, maxSize: 2000
    }
}
