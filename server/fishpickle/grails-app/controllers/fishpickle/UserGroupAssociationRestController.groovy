package fishpickle

import grails.converters.JSON

class UserGroupAssociationRestController {
	
	def renderUtil

    def index() { }
	
	/**
	* if id is not null, return this association
	* url: /rest/userGroupAssociation/{id}
	*
	* if id is null, return a list of all associations
	* url: /rest/userGroupAssociation
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
	 * associate an existing user with an existing group
	 * url: /rest/userGroupAssociation
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
