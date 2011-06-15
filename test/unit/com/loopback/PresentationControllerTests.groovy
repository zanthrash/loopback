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

    @Test
    void addFailsWhenSpeakerIsNotFound() {
        controller.add()

        controller.metaClass.methods.unique().sort().each {println it}

        assertThat controller.redirectArgs.size(),  equalTo(2)
        assertThat controller.redirectArgs.controller, equalTo("speaker")
        assertThat controller.redirectArgs.action, equalTo("index")

        assert controller.flash.message == "Could not find a Speaker to add Test Presentation to your list at this time"
    }

    @Test
    void addSucceedsWhenSpeakIsFound() {
        controller.springSecurityService = [currentUser: user]
        controller.accessCodeService = [createFrom: {title, event -> "abcd1234"}]
        mockDomain Presentation

        controller.add()

        assert controller.redirectArgs.size() == 2
        assert controller.redirectArgs.controller == "speaker"
        assert controller.redirectArgs.action == "index"

        assert controller.flash.message == "'Test Presentation' added with access code: abcd1234"
        assertThat controller.flash.message.toString(), equalTo("'Test Presentation' added with access code: abcd1234")
    }

    @Test
    void addFailsWhenPresentationFailsValidationOnSave() {
        controller.springSecurityService = [currentUser: user]
        controller.accessCodeService = [createFrom: {tilte, event -> "abcd1234"}]
        controller.params.title = null //Will cause validation error
        mockDomain Presentation

        controller.add()

        assert controller.redirectArgs.size() == 2
        assert controller.redirectArgs.controller == "speaker"
        assert controller.redirectArgs.action == "index"

        assert controller.flash.message == "Could not add null to your list at this time"
    }


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

    @Test
    void showPresentationWithOneComment() {
        controller.params.id = 1
        def presentation = new Presentation(id: 1, comments:[new Comment(clientIPAddress: 'joey', text: 'blah')])
        mockDomain Presentation, [presentation]

        def model = controller.show()

        assert model.presentation == presentation
        assert model.comments.size() == 1
        assert model.commentCount == ['joey':1]
    }

    @Test
    void showPresentationWithManyComments() {
        controller.params.id = 1
        def comments = []
        3.times{ comments << new Comment(id:it, clientIPAddress: "$it", text: "$it")}
        def presentation = new Presentation(comments: comments)
        mockDomain Presentation, [presentation]

        def model = controller.show()

        assert model.presentation == presentation
        assert model.comments.size() == 3
        assert model.commentCount == ["0":1, "1":1, "2":1]
    }

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
