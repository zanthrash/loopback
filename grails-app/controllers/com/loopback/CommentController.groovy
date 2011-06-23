package com.loopback

class CommentController {
	def commentService

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

	def myComments = {
		def presentation = Presentation.findByAccessCode(params.accessCode)
        if(presentation) {
			def myComments = commentService.commentsForIp(request.getRemoteAddr(), presentation)
            render view:'my', model:[presentation:presentation, myComments: myComments]
        } else {
            flash.message = "Could not find presentation with that access code"
            redirect controller:'login', action: 'auth'
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

