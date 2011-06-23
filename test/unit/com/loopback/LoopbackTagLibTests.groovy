package com.loopback

import grails.test.TagLibUnitTestCase
import org.codehaus.groovy.grails.plugins.web.taglib.RenderTagLib

class LoopbackTagLibTests extends TagLibUnitTestCase {
	protected void setUp() {
		super.setUp()
	}

	void testFixedWidthIpDefaultsTag() {
		tagLib.fixedWidthIp(null, null)
		assertEquals "................", tagLib.out.toString()
	}

	void testFixedWidthIpParameters() {
		tagLib.fixedWidthIp(ip: '127.0.0.1', width: '20', pad: '=', null)
		assertEquals "127.0.0.1===========", tagLib.out.toString()

		shouldFail {
			tagLib.fixedWidthIp(ip: '127.0.0.1', width: 'not-a-number', pad: '=', null)
		}
	}

	void testComment() {
		Comment comment = new Comment(
				id: 1,
				dateCreated: new Date(),
				text: 'comment_text',
				clientIPAddress: '127.0.0.1'
		)
		tagLib.comment(comment: comment, null)
		println tagLib.renderArgs
		assertEquals "/presentation/comment", tagLib.renderArgs.template
		assertEquals comment, tagLib.renderArgs.model.comment
	}

	void testComments() {
		Comment comment1 = new Comment(
				id: 1,
				dateCreated: new Date(),
				text: 'comment_text',
				clientIPAddress: '127.0.0.1'
		)
		Comment comment2 = new Comment(
				id: 2,
				dateCreated: new Date(),
				text: 'comment_textz',
				clientIPAddress: '127.0.0.1'
		)
		tagLib.comments(comments: [comment1, comment2]) {'>comment<'}
		assertEquals(">comment<>comment<", tagLib.out.toString())
	}
}