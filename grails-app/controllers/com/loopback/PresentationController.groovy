package com.loopback

import grails.plugins.springsecurity.Secured

class PresentationController {

    def index = { }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def show = {
        def presentation = Presentation.get(params.id)
        [presentation:presentation, commentCount: presentation.commentCountByMember()]
    }
}
