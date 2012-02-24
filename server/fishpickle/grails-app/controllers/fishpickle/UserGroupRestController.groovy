package fishpickle

import grails.converters.JSON

import org.codehaus.groovy.grails.web.json.JSONObject

class UserGroupRestController {

	def renderUtil
	
    def index() { }
	
	def show = {
		if (params.children == "users") {
			render UserGroup.findById(params.id).users() as JSON
		}else if(params.id){
			render User.findById(params.id) as JSON
		} else{
			render User.list() as JSON
		}
	}
	
	/**
	 * create a new or update an existing group depending if an id is passed with the object
	 */
	def save = {
		def groupUser = JSON.parse(params.group)
		
		 if (renderUtil.isIdValid( groupUser.id)) {
			update();
		} else {
			UserGroup group = new UserGroup(groupUser)
			renderUtil.saveAndRender(this, group)
		}
	}
	
	/**
	 * update an existing group
	 */
	def update = {
		def jsonGroup = JSON.parse(params.group)
		UserGroup group = new UserGroup(jsonGroup)
		UserGroup dbGroup = User.findById(jsonGroup.id)
		dbGroup.properties = group.properties
		
		renderUtil.saveAndRender(this, dbGroup)
	}
}
