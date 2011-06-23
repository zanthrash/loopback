package com.loopback

class LoopbackTagLib {
	def fixedWidthIp = { attrs, body ->
		def width = attrs?.width?.toInteger() ?: 16
		def pad = attrs?.pad ?: '.'
		def ip = attrs?.ip ?: ''
		out << ip.padRight(width, pad)
	}

	def comment = { attrs, body ->
		out << render(template: "/presentation/comment", model: [comment: attrs.comment])
	}

	def comments = { attrs, body ->
		def comments = attrs.comments
		if (comments) {
			for(comment in comments) {
				out << body(comment: comment)
			}
		}
	}
}
