package fishpickle

import grails.converters.JSON

class UserRestController {

	def renderUtil
	
	
	def index() {
	}

	/**
		* if children == groups:  Return all groups for the user with the given {id}<br>
		* url: <b>/rest/user/{id}/groups</b><br>
		* <br>
		* if children  == null and id is not null, return this user<br>
		* url: <b>/rest/user/{id}</b><br>
		* <br>
		* if children and id are both null, return a list of all users<br>
		* url: <b>/rest/user</b><br>
		* @return
	*/
	def show = {
		if (params.children == "groups") {
			renderUtil.renderObject(this, User.findById(params.id).groups())
		}else if(params.id){
			renderUtil.renderObject(this, User.findById(params.id))
		} else{
			renderUtil.renderObject(this, User.list())
		}
	}

	/**
	 * if children param == groups:  Create a new group and add it to the user whose id is in the url<br>
	 * url:  <b>/rest/user/{id}/groups</b><br>
	 * <br>
	 * if children == null, this is either a new user or an update to a user depending if a id is passed with the post<br>
	 * url:  <b>/rest/user</b><br>
	 */
	def save = {
		// 
		if (params.children == "groups") {
			
			//Create new Group
			def group = new UserGroup(JSON.parse(params.group))
			if (!group.save()) renderUtil.renderError(this, group.errors)
			
			//Find the user
			User user = User.findById(params.id)
			
			//Associate the user to this group.  Since it is a new group, this user will be the administrator
			UserGroupAssociation.link(user, group, true)
			
			renderUtil.renderObject(this, group)
		} else {
			def jsonUser = JSON.parse(params.user)

			if (renderUtil.isIdValid( jsonUser.id)) {
				update();
			} else {
				User user = new User(jsonUser)
				renderUtil.saveAndRender(this, user)
			}
			
		}


	}

	/**
	 * update existing user<br>
	 * <br>
	 * Not called externally because PUT doesn't work (grails / tomcat issue where the data is null), this is done with a POST instead<br>
	 */
	def update = {
		def jsonUser = JSON.parse(params.user)
		User user = new User(jsonUser)
		User dbUser = User.findById(jsonUser.id)
		dbUser.properties = user.properties
		
		renderUtil.saveAndRender(this, dbUser)
	}
}
