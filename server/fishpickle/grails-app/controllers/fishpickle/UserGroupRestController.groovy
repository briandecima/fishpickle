package fishpickle

import grails.converters.JSON

class UserGroupRestController {

	def renderUtil
	
    def index() { }
	
	/**
	* if children == users:  Return all users for the group with the given {id}
	* url: /rest/group/{id}/users
	*
	* if children  == null and id is not null, return this group
	* url: /rest/group/{id}
	*
	* if children and id are both null, return a list of all groups
	* url: /rest/group
	* @return
	*/
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
	 * url: /rest/group
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
	 * 
	 * Not called externally because PUT doesn't work (grails / tomcat issue where the data is null)
	 */
	def update = {
		def jsonGroup = JSON.parse(params.group)
		UserGroup group = new UserGroup(jsonGroup)
		UserGroup dbGroup = User.findById(jsonGroup.id)
		dbGroup.properties = group.properties
		
		renderUtil.saveAndRender(this, dbGroup)
	}
}
