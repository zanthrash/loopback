package com.loopback

import grails.plugin.spock.ControllerSpec
import spock.lang.Shared
import spock.lang.Unroll

class PresentationControllerSpec extends ControllerSpec{

    @Shared def user = new User(id:1)

    @Unroll("add presentation for user: #testUser with title: #title")
    def "call to add a new presentation for logged in user"() {
        given:"collaborators are mocked"
            mockDomain Presentation
            mockDomain Speaker, [new Speaker(user:user)]
            controller.springSecurityService = [currentUser: testUser ]
            controller.accessCodeService = [createFrom:{title, event -> "1234abcd"}]
        and:"prarams are set"
            controller.params.event = "Event Name"
            controller.params.date = new Date()
            controller.params.title = title
        when:"call the action"
            controller.add()

        then:"should be redirected to '/speaker/index'"
            controller.redirectArgs.controller == 'speaker'
            controller.redirectArgs.action == 'index'

        and: "should have correct flash message"
            controller.flash.message == expectedFlashMessage

        where:
            title   | testUser  |expectedFlashMessage
            'test'  | user      |"'test' added with access code: 1234abcd"
            null    | user      |"Could not add null to your list at this time"
            'test'  | null      |"Could not find a Speaker to add test to your list at this time"
    }
}
