package fishpickle

import grails.converters.JSON

class UserGroupRestController {

	def renderUtil
	
    def index() { }
	
	def show = {
		if (params.children == "users") {
			renderUtil.renderObject(this, UserGroup.findById(params.id).users())
		}else if(params.id){
			renderUtil.renderObject(this, User.findById(params.id))
		} else{
			renderUtil.renderObject(this, User.list())
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
