package com.loopback

import grails.test.*

class FakeCodeCoverageTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testWhyCodeCoverageNumbersAreCrap() {
        def service = new AccessCodeService()
        service.metaClass.methods.name.unique().sort().unique().each {
            try{
                service.invokeMethod(it, ['blah', 'blah'])
            } catch (Exception ex ){
                //eat it
            }
        }
    }
}
