class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/login"(controller: 'login', action:'auth')

		"/comment/$action/$accessCode"(controller: 'comment')

		"/"(controller:'speaker', action:"index")
		"500"(view:'/error')
		"404"(view:'/error404')
	}
}
