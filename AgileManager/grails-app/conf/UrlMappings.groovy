class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/leaderboard"(view:"/leaderboard/list")

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
