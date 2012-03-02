package fishpickle

import java.util.List;

class UserGroup {
	
	static searchable = true

     static constraints = {
		name(blank:false, maxSize:50)
		description(nullable:true, maxSize:255)
    }
	
	String name
	String description
	boolean isPrivate=false;

	static hasMany = [userGroupAssociations:UserGroupAssociation]
	
	List users() {
		userGroupAssociations.collect{it.user};
	}
}
