package com.loopback

import grails.test.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Before
import org.junit.After
import org.junit.Test
import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.equalTo
import junit.framework.Test
import org.junit.Test

@RunWith(JUnit4.class)
class PresentationControllerTests extends ControllerUnitTestCase {

    User user

    @Before
    void setUp() {
        super.setUp()
        controller.springSecurityService = [currentUser:null]
        controller.params.title = "Test Presentation"
        user = new User(id:1)
        mockDomain Speaker, [new Speaker(user:user)]
    }

    @After
    void tearDown() {
        super.tearDown()
    }

    //Controller Action with redirect
    @Test
    void addFailsWhenSpeakerIsNotFound() {
        controller.springSecurityService = [currentUser: null]
        controller.add()

        assertThat controller.redirectArgs.size(),  equalTo(2)
        assertThat controller.redirectArgs.controller, equalTo("speaker")
        assertThat controller.redirectArgs.action, equalTo("index")

        assert controller.flash.message == "Could not find a Speaker to add Test Presentation to your list at this time"
    }




    //Controller action that returns a model (0, 1, Many testing)
    @Test
    void showPresentationWithZeroComments() {
        controller.params.id = 1
        Presentation presentation = new Presentation(id: 1)
        mockDomain Presentation, [presentation]

        def model = controller.show()

        assert model.size() == 3
        assert model.presentation == presentation
        assert model.comments == null
        assert model.commentCount == [:]
    }




    //Temporal Testing (mocking out time)
    @Test
    void checkTimeShouldHaveTimeLeft() {
        controller.params.date = "01/30/2011"
        controller.checkTime()

        assert controller.response.contentAsString == "Still time left"
    }

    @Test
    void checkTimeShouldHaveExpired() {
        controller.params.date = "01/30/2011"
        def system = mockFor(System)
        system.demand.static.currentTimeMillis(1..1) {-> new Date("01/29/2011").time}

        controller.checkTime()

        assert controller.response.contentAsString == "Time expired"
    }

}
