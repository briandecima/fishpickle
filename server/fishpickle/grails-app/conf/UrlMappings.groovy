class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/rest/user/$id?/$children?"(controller:"userRest", parseRequest:true){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
		"/rest/login/$loginName"(controller:"loginRest", parseRequest:true){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
		"/rest/group/$id?/$children?"(controller:"userGroupRest", parseRequest:true){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
		"/rest/userGroupAssociation/$id?"(controller:"userGroupAssociationRest", parseRequest:true){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
		"/rest/search/group/$q?"(controller:"userGroupSearchRest", parseRequest:true){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
