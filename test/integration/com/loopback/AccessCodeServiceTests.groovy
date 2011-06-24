package com.loopback

import grails.test.GrailsUnitTestCase
import org.junit.Test
import static org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.core.IsNot.not

@RunWith(JUnit4.class)
class AccessCodeServiceTests extends GrailsUnitTestCase{

    def accessCodeService

    @Override protected void setUp() {
        super.setUp()
    }

    @Override protected void tearDown() {
        super.tearDown()
    }

    @Test
    void serviceShouldNotBeNull() {
        assertNotNull accessCodeService
    }

    @Test
    void createTwoAccessCodesForPresentationShouldBeDifferent() {
        def presentationName = "PresentationOne"
        def eventName = "EventOne"

        def accessCodeOne = accessCodeService.createFrom(presentationName, eventName)
        def accessCodeTwo = accessCodeService.createFrom(presentationName, eventName)

        assertThat(accessCodeOne, not( equalTo( accessCodeTwo)))
    }

    @Test
    void createTheSameAccessCodeTwice() {

        def mockSystem = mockFor(System)
        mockSystem.demand.static.nanoTime(1..2){-> new Date()}

        def presentationName = "PresentationOne"
        def eventName = "EventOne"

        def accessCodeOne = accessCodeService.createFrom(presentationName, eventName)
        def accessCodeTwo = accessCodeService.createFrom(presentationName, eventName)

        assertThat(accessCodeOne,  equalTo( accessCodeTwo))
    }

}
