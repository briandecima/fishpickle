package fishpickle

import grails.converters.JSON

import org.codehaus.groovy.grails.web.json.JSONObject

class UserRestController extends BaseJSONController{

	def index() {
	}

	def show = {
		if (params.children == "groups") {
			render User.findById(params.id).groups() as JSON
		}else if(params.id){
			render User.findById(params.id) as JSON
		} else{
			render User.list() as JSON
		}
	}

	/**
	 * if children param == groups:  Create a new group and add it to the user whose id is in the url
	 * url:  /rest/user/{id}/groups -- add a new group to the user with the given {id}
	 * 
	 * if children == null, this is either a new user or an update to a user depending if a id is passed with the post
	 * url:  /rest/user
	 */
	def save = {
		// 
		if (params.children == "groups") {
			
			//Create new Group
			def group = new UserGroup(JSON.parse(params.group))
			if (!group.save()) renderError(group.errors)
			
			//Find the user
			User user = User.findById(params.id)
			
			//Associate the user to this group.  Since it is a new group, this user will be the administrator
			UserGroupAssociation.link(user, group, true)
			
			renderObject(group)
		} else {
			def jsonUser = JSON.parse(params.user)

			if (isIdValid( jsonUser.id)) {
				update();
			} else {
				User user = new User(jsonUser)
				saveAndRender(user)
			}
			
		}


	}

	/**
	 * update existing user
	 */
	def update = {
		def jsonUser = JSON.parse(params.user)
		User user = new User(jsonUser)
		User dbUser = User.findById(jsonUser.id)
		dbUser.properties = user.properties
		
		saveAndRender(dbUser)
	}
}
