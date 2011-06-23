package com.loopback

import grails.test.*

class LoopbackTagLibGSPTests extends GroovyPagesTestCase {
	void testFixedWidthIp() {
		def template = '<g:fixedWidthIp ip="127.0.0.1" width="21" pad="-"/>'

		assertOutputEquals('127.0.0.1------------', template)
	}

	void testComment() {
		def template = '<g:comment comment="${comment}"/>'

		Comment comment = new Comment(
				id: 1,
				dateCreated: Date.parse("MM/dd/yyyy","6/21/2011"),
				text: 'comment_text',
				clientIPAddress: '127.0.0.1'
		)
		def expected = """<div class="comment" id="comment_">
    <h2>comment_text</h2>
    <div class="commentInfo">
        <span class="comment_date">Jun 21, 2011 @ 12:00 AM </span>
        <span class="comment_client">127.0.0.1</span>
    </div>
</div>
"""
		assertOutputEquals(expected, template, [comment: comment])
	}
}
