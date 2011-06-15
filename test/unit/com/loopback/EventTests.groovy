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
        Expectations.applyTo Event
    }

    @After
    void tearDown() {
        super.tearDown()
    }

    @Test
    void eventNameShouldNotValidateIfNull() {
        def event = new Event()

        assertFalse event.validate()
        assertTrue event.hasErrors()
        event.errors.getAllErrors().each{
            println it.field
        }
        assertThat event.errors.getFieldErrorCount('name'), equalTo(1)
        assert event.errors.getFieldError('name').code == 'nullable'
    }

    @Test
    void eventNameShouldNotBeNull() {

        def event = new Event(name:'jojo')
        event.expectNameIsNotNullable()
        event.expectNameIsNotBlank()
        event.expectNameHasMaxSize(40)
        event.expectNameHasAValidator()
        event.expectNameIsValid()
    }
}
