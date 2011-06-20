package com.loopback

import java.security.MessageDigest
import sun.security.util.BigInt

class AccessCodeService {

    static transactional = true

    def createFrom(presentationTitle, event) {
        def payload = "${presentationTitle}${event}${System.nanoTime()}"
        MessageDigest md = createMessageDigest(payload)

        def sha1Hex = createSha1Hex(md)

        sha1Hex[0..7]
    }

    MessageDigest createMessageDigest(GString payload) {
        MessageDigest md = MessageDigest.getInstance("SHA1")
        md.update payload.getBytes()
        return md
    }

    String createSha1Hex(MessageDigest md) {
        return new BigInteger(1, md.digest()).toString(16).padLeft(40, '0')
    }
}
