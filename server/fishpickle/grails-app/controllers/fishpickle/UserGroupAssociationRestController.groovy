package fishpickle

import grails.converters.JSON

class UserGroupAssociationRestController {
	
	def renderUtil

    def index() { }
	
	def show = {
		if(params.id){
			renderUtil.renderObject(this, UserGroupAssociation.findById(params.id))
		} else{
			renderUtil.renderObject(this, UserGroupAssociation.list())
		}
	}
	
	/**
	 * create a new or update an existing group depending if an id is passed with the object
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
