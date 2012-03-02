package fishpickle

import grails.converters.JSON

class UserGroupSearchRestController {

    def index() { }
	
	def show = {
		def resultsMap = UserGroup.search(params.q + "*", params)
		
		render resultsMap.results as JSON
	}

}
