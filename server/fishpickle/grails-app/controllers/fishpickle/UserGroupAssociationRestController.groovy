package fishpickle

import grails.converters.JSON

class UserGroupAssociationRestController {
	
	def renderUtil

    def index() { }
	
	/**
	* if id is not null, return this association<br>
	* url: <b>/rest/userGroupAssociation/{id}</b><br>
	*<br>
	* if id is null, return a list of all associations<br>
	* url: <b>/rest/userGroupAssociation</b><br>
	* <br>
	* @return
	*/
	def show = {
		if(params.id){
			renderUtil.renderObject(this, UserGroupAssociation.findById(params.id))
		} else{
			renderUtil.renderObject(this, UserGroupAssociation.list())
		}
	}
	
	/**
	 * associate an existing user with an existing group<br>
	 * url: <b>/rest/userGroupAssociation</b><br>
	 * 
	 */
	def save = {
		def associationJson = JSON.parse(params.userGroupAssociation)
		
		User user = User.findById(associationJson.userId)
		if (!user) renderUtil.renderError(this, "user " + associationJson.userId + " cannot be found")
		
		UserGroup group = UserGroup.findById(associationJson.groupId)
		if (!group) renderUtil.renderError(this, "group " + associationJson.groupId + " cannot be found")
		
		UserGroupAssociation association = UserGroupAssociation.link(user, group, false)
		
		renderUtil.renderObject(this, association)
	}
}
