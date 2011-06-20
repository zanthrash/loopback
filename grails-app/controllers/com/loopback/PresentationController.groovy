package com.loopback

import grails.plugins.springsecurity.Secured

class PresentationController {

    def springSecurityService
    def accessCodeService

    def index = { }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def show = {
        def presentation = Presentation.get(params.id)
        def comments = presentation.comments?.sort {a,b -> b.dateCreated <=> a.dateCreated}
        [presentation:presentation, comments:comments, commentCount: presentation.commentCountByMember()]
    }

    @Secured(['ROLE_USER'])
    def add = {
        def user = springSecurityService.currentUser
        def speaker = Speaker.findByUser( user )
        if(speaker) {
           log.info "Speaker ${speaker.id} found"
           def accessCode = accessCodeService.createFrom(params.title, params.eventName)
           def presentation = new Presentation(speaker:speaker,
                   event: params.eventName,
                   title: params.title,
                   date: params.date,
                   accessCode: accessCode
           )
           if (presentation.save()) {
               flash.message = "'${presentation.title}' added with access code: ${presentation.accessCode}"
           } else {
              flash.message = "Could not add ${params.title} to your list at this time"
           }
        } else {
            flash.message = "Could not find a Speaker to add ${params.title} to your list at this time"
        }
        redirect controller: "speaker", action: "index"
    }


    def checkTime = {
        Date date = new Date(params.date)

        if(date.time < System.currentTimeMillis()) {
            render "Still time left"
        } else {
            render "Time expired"
        }

    }

}
