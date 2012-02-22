package fishpickle

class UserGroup {

     static constraints = {
		name(blank:false, maxSize:50)
		description(nullable:true, maxSize:255)
    }
	
	String name
	String description
	String isPrivate=false;

	static hasMany = [userGroupAssociations:UserGroupAssociation]
}
