package com.loopback

import grails.test.*
import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.core.IsNot.not

class CommentServiceTests extends GrailsUnitTestCase {

	def commentService

	void testCommentsForIp() {
		Presentation presentation = Presentation.build()
		presentation.addToComments(
				Comment.build(
						clientIPAddress: "192.168.0.1",
						text: "wow awesome"
				)
		)

		presentation.addToComments(
				Comment.build(
						clientIPAddress: "192.168.0.1",
						text: "Superb description"
				)
		)
		presentation.addToComments(
				Comment.build(
						clientIPAddress: "127.0.0.1",
						text: "This needs work"
				)

		)
		presentation.save(failOnError: true)


		assertEquals(2, commentService.commentsForIp("192.168.0.1", presentation)?.size())

		assertEquals(1, commentService.commentsForIp("127.0.0.1", presentation)?.size())


	}
}
