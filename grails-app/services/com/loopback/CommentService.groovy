package com.loopback

class CommentService {

	static transactional = true

	List<Comment> commentsForIp(String ip, Presentation presentation) {
		def c = Comment.createCriteria()
		return c.list {
			eq("clientIPAddress", ip)
			eq("presentation", presentation)
			order("dateCreated", "desc")
		}
	}
}
