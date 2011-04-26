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
        } else {
            flash.message = "Could not find presentation or empty comment."
        }

        render view:'comment', model:[presentation:presentation]
    }

    def code = {
        def presentation = Presentation.findByAccessCode(params.code)
        if(presentation) {
            render view:'comment', model:[presentation:presentation]
        }
    }
}

