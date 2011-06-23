package com.loopback

import org.springframework.beans.factory.InitializingBean
import org.cometd.bayeux.Bayeux
import org.cometd.bayeux.server.BayeuxServer
import org.cometd.server.BayeuxServerImpl
import org.cometd.bayeux.server.ServerSession
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

class CommentService implements InitializingBean{

    BayeuxServer bayeux
    def bayeuxSession

    static transactional = true

    void afterPropertiesSet() {
        bayeuxSession = bayeux.newLocalSession()
        bayeuxSession.handshake()
    }

    def publishComment(Presentation presentation, Comment comment) {
        def channel = "/comment/${presentation.id}"

        def g = new ApplicationTagLib()


    }


}
