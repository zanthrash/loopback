package com.loopback

import grails.plugins.springsecurity.Secured

class PresentationController {

    def index = { }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def show = {
        def presentation = Presentation.get(params.id)
        def comments = presentation.comments.sort {a,b -> b.dateCreated <=> a.dateCreated}
        [presentation:presentation, comments:comments, commentCount: presentation.commentCountByMember()]
    }
}
