package com.loopback

import grails.plugins.springsecurity.Secured

class SpeakerController {

    def springSecurityService

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def index = {
        def user = springSecurityService.currentUser
        def speaker = Speaker.findByUser(user)

        [speaker:speaker]
    }



}
