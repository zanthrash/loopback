package com.loopback

import grails.plugins.springsecurity.Secured

class PresentationController {

    def springSecurityService
    def accessCodeService

    def index = { }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def show = {
        def presentation = Presentation.get(params.id)
        def comments = presentation.comments.sort {a,b -> b.dateCreated <=> a.dateCreated}
        [presentation:presentation, comments:comments, commentCount: presentation.commentCountByMember()]
    }

    @Secured(['ROLE_USER'])
    def add ={
        def user = springSecurityService.currentUser

        log.debug "${user.dump()}"
        def speaker = Speaker.findByUser( user )
        log.debug "${speaker.dump()}"

        if(speaker) {
           def accessCode = accessCodeService.createFrom(params.title, params.eventName)
           def presentation = new Presentation(speaker:speaker,
                   event: Event.get(1),
                   title:params.title,
                   date:params.date,
                   accessCode: accessCode
           )
           if (presentation.save(failOnError:true)) {
               flash.message = "'${presentation.title}' added with access code: ${presentation.accessCode}"
           } else {
              flash.message = "Could not add ${params.title} to your list at this time"
           }
        } else {
            flash.message = "Could not add ${params.title} to your list at this time"
        }
        redirect controller: "speaker", action: "index"
    }

}
