package fishpickle

import grails.converters.JSON

class UserRestController {

    def index() { }
	
	def show = {
		if (params.children == "groups") {
			User user = User.findById(params.id)
			render user.userGroupAssociations.collect{it.group} as JSON;
		}else if(params.id){
			render User.findById(params.id) as JSON
		}
		else{
			render User.list() as JSON
		}
	}
}
