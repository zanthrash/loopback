package com.loopback

class PresentationController {

    def index = { }

    def show = {
        def presentation = Presentation.get(params.id)
        [presentation:presentation]
    }
}
