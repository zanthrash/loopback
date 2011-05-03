package com.loopback

class CommentController {

    def index = {
    }

    def post = {
        def presentation = Presentation.findByAccessCode(params.accessCode)
        if(presentation && params.comment){
            def comment = new Comment(text: params.comment, clientIPAddress: request.getRemoteAddr())
            presentation.addToComments(comment)
            if(presentation.save()){
                flash.message = "Comment added"
            } else{
                flash.message = "There was and issue saving your comment"
            }
        }

        render view:'comment', model:[presentation:presentation]
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

