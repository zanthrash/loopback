package com.loopback

import grails.test.*
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.hamcrest.CoreMatchers.*
import static org.junit.matchers.JUnitMatchers.*
import com.lonecyprus.grails.test.Expectations
import org.junit.After

@RunWith(JUnit4.class)
class EventTests extends GrailsUnitTestCase {

    @Before
    void setup() {
        super.setUp()
        mockForConstraintsTests Event
    }

    @After
    void tearDown() {
        super.tearDown()
    }

    @Test
    void testEventNameShouldNotValidateIfNull() {
        def event = new Event()

        assertFalse event.validate()
        assertTrue event.hasErrors()

        assert event.errors['name'] == 'nullable'
    }

    @Test
    void testEventNameConstraints() {
        Expectations.applyTo Event

        def event = new Event()

        event.expectNameIsNotNullable()
        event.expectNameIsNotBlank()
        event.expectNameHasMaxSize(40)
        event.expectNameDoesNotHaveMinSize(0)
        event.expectNameHasAValidator()

        event.expectNameAreValid('jojo', 'bobo')
    }
}
