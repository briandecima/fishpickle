package fishpickle

import grails.converters.JSON

class UserGroupRestController {

	def renderUtil
	
    def index() { }
	
	/**
	* if children == users:  Return all users for the group with the given {id}<br>
	* url: <b>/rest/group/{id}/users</b><br>
	*<br>
	* if children  == null and id is not null, return this group<br>
	* url: <b>/rest/group/{id}</b><br>
	*<br>
	* if children and id are both null, return a list of all groups<br>
	* url: <b>/rest/group</b><br>
	* <br>
	* @return
	*/
	def show = {
		if (params.children == "users") {
			renderUtil.renderObject(this, UserGroup.findById(params.id).users())
		}else if(params.id){
			renderUtil.renderObject(this, UserGroup.findById(params.id))
		} else{
			renderUtil.renderObject(this, UserGroup.list())
		}
	}
	
	/**
	 * create a new or update an existing group depending if an id is passed with the object<br>
	 * url: <b>/rest/group</b><br>
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
	 * update an existing group<br>
	 * <br>
	 * Not called externally because PUT doesn't work (grails / tomcat issue where the data is null), this is done with a POST instead<br>
	 */
	def update = {
		def jsonGroup = JSON.parse(params.group)
		UserGroup group = new UserGroup(jsonGroup)
		UserGroup dbGroup = User.findById(jsonGroup.id)
		dbGroup.properties = group.properties
		
		renderUtil.saveAndRender(this, dbGroup)
	}
}
