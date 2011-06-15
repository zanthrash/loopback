package com.loopback

import grails.test.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Before
import org.junit.After
import org.junit.Test
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertFalse

@RunWith(JUnit4.class)
class PresentationTests extends GrailsUnitTestCase {

    Presentation presentation
    @Before
    void setUp() {
        super.setUp()
        mockForConstraintsTests Presentation
        presentation = new Presentation(title: 'presentation one', accessCode: '1234', speaker: new Speaker())
    }

    @After
    void tearDown() {
        super.tearDown()
    }

    @Test
    void minAttributesShouldPass() {
        assertTrue "Presentation shoud validate", presentation.validate()
    }

    @Test
    void nullTitleShouldFail() {
        presentation.title = null

        assertFalse presentation.validate()
        assertThat presentation.errors['title'], equalTo('nullable')
    }

    @Test
    void blankTitleShouldFail() {
        presentation.title = ""

        assertFalse presentation.validate()
        assertThat presentation.errors['title'], equalTo('blank')
    }

    @Test
    void nullAccessCodeShouldFail() {

    }
}
