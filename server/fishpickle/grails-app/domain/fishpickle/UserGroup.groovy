package fishpickle

class UserGroup {

     static constraints = {
		name(blank:false, maxSize:50)
		description(maxSize:255)
    }
	
	String name
	String description

	static hasMany = [userGroupAssociations:UserGroupAssociation]
}
