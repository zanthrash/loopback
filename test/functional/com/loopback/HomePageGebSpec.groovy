package com.loopback

import geb.spock.GebSpec

class HomePageGebSpec extends GebSpec {

	void "Test Homepage"() {
		when: "going to the homepage"
			go "/loopback/"
		then:
			$("#header_text").text() == "Loopback"
		and: "There should be two forms, login and attend"
			$("form").size() == 2
		and: "Should be two headings"
			$("div.fheader")*.text() == ["Login", "Attend"]
	}

	String getBaseUrl() {
		"http://localhost:8080/loopback"
	}

}
