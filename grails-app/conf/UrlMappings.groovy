class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/login"(controller: 'login', action:'auth')

		"/"(controller:'speaker', action:"index")
		"500"(view:'/error')
		"404"(view:'/404d')
	}
}
