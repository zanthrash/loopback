import com.loopback.Role
import com.loopback.User
import com.loopback.UserRole
import com.loopback.Event
import com.loopback.Speaker
import com.loopback.Presentation

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        initSecurity()
        initEvent()
    }

    def initSecurity() {
        log.info "initSecurity..."
        def admin = new Role(authority:"ROLE_ADMIN").save(flush:true, failOnError:true)
        def user = new Role(authority:"ROLE_USER").save(flush:true, failOnError:true)

        def adminUser = new User(username: 'admin', password: springSecurityService.encodePassword('password'), enabled: true).save(flush:true, failOnError:true)
        UserRole.create adminUser, admin, true

        def userUser = new User(username: 'user', password: springSecurityService.encodePassword('password'), enabled: true).save(flush:true, failOnError:true)
        UserRole.create userUser, user, true
    }

    def initEvent() {
        log.info "initEvent..."
        def event = new Event(name: "The Main Event")

        def presentationOne = new Presentation(title:"How to shave a yak in 43 steps!", accessCode:"1234")
        def speakerOne = new Speaker(user: createUser('speaker1'), firstName: 'Speaker', lastName: 'One', bio: "Code Master")

//        presentationOne.addToSpeakers(speakerOne)
        speakerOne.addToPresentations(presentationOne)

        speakerOne.save(flush:true, failOnError:true)
        event.addToPresentations(presentationOne)
        event.save(flush:true, failOnError:true)

    }

    def createUser(username) {
        def role = Role.findByAuthority("ROLE_USER")
        def user = new User(username: username, password: springSecurityService.encodePassword('password'), enabled: true).save(flush: true, failOnError: true)
        UserRole.create user, role, true
        user
    }

    def destroy = {
    }
}
