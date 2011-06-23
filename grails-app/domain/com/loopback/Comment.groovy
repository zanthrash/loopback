package com.loopback

class Comment {

    Date dateCreated
    String text
    String clientIPAddress

	static belongsTo = [presentation: Presentation]

    static constraints = {
        text nullable: false, blank:false, maxSize: 2000
    }
}
