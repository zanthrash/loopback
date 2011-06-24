package com.loopback

import grails.test.*

class URLMappingsTests extends PatchedGrailsUrlMappingsTestCase {
	void setUp() {
		super.setUp()
	}

	void tearDown() {
		super.tearDown()
	}

	void testLoginPage() {
		assertUrlMapping("/login", controller: 'login', action: 'auth')
	}

	void testErrorPages() {
		assertUrlMapping(500, view: "error")
		assertUrlMapping(404, view: "error404")
	}

	void testSiteRoot() {
		assertUrlMapping("/", controller: 'speaker', action: 'index')
	}

	void testCommentMappings() {
		assertUrlMapping("/comment/code/12345", controller: 'comment', action: 'code') {
			accessCode = "12345"
		}
		assertUrlMapping("/comment/post/12345", controller: 'comment', action: 'post') {
			accessCode = "12345"
		}
	}

	void testDefaultControllerActionIdMapping() {
		assertUrlMapping("/event/show/3210", controller: 'event', action: 'show') {
			id = 3210
		}
		assertUrlMapping("/presentation/show/125", controller: 'presentation', action: 'show') {
			id = 125
		}
	}
}
