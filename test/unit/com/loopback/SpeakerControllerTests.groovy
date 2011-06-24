package com.loopback

import grails.test.*

class SpeakerControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCallingIndexForLoggedInUserShouldReturnSpeakerAndPresentations() {
        User user = new User(id: 1)
        mockDomain Speaker, [new Speaker(user: user, presentations:[] as SortedSet) ]
        controller.springSecurityService = [currentUser: user]
        def model = controller.index()

        assertEquals model.size() , 2
        assertNotNull model.speaker
        assertNotNull model.presentations
    }
}
