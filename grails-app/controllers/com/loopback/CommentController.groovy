package com.loopback

import org.springframework.beans.factory.InitializingBean
import org.cometd.bayeux.server.BayeuxServer
import grails.converters.JSON

class CommentController implements InitializingBean{

    BayeuxServer bayeux
    def bayeuxSession

    def index = {
    }

    void afterPropertiesSet() {
        bayeuxSession = bayeux.newLocalSession()
        bayeuxSession.handshake()
    }

    def post = {
        def presentation = Presentation.findByAccessCode(params.accessCode)
        if(presentation && params.comment){
            def comment = new Comment(text: params.comment, clientIPAddress: request.getRemoteAddr())
            presentation.addToComments(comment)
            if(presentation.save(flush:true)){
                flash.message = "Comment added"
                publishComment(presentation, comment)
            } else{
                flash.message = "There was and issue saving your comment"
            }
        }

        render view:'comment', model:[presentation:presentation]
    }

    def publishComment(Presentation presentation, Comment comment) {
        def channel = "/comment/${presentation.id}"

        try {
            def commentHtml = g.render(template: "/presentation/comment", model: [comment:comment])
            def commentCountHtml = g.render(template:"/presentation/commentCount", model:[commentCount:presentation.commentCountByMember()])
            def payload = ['commentHtml':commentHtml, 'commentCountHtml':commentCountHtml] as JSON
            log.warn "<<<<< Payload: ${payload}"
            bayeuxSession.getChannel(channel).publish(payload.toString())
        } catch (Exception ex){
            log.warn "Could not publish comment ${comment.id} for presentation: ${presentation.id}"
        }
    }

    def code = {
        def presentation = Presentation.findByAccessCode(params.accessCode)
        if(presentation) {
            render view:'comment', model:[presentation:presentation]
        } else {
            flash.message = "Could not find presentation with that access code"
            redirect controller:'login', action: 'auth'
        }
    }


}

