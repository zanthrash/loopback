package loopback

import java.security.MessageDigest
import sun.security.util.BigInt

class AccessCodeService {

    static transactional = true

    def createFrom(presentationTitle, event) {
        def payload = "${presentationTitle}${event}${System.nanoTime()}"
        MessageDigest md = MessageDigest.getInstance("SHA1")
        md.update payload.getBytes()

        def sha1Hex = new BigInteger(1,md.digest()).toString(16).padLeft(40,'0')

        sha1Hex[0..7]
    }
}
