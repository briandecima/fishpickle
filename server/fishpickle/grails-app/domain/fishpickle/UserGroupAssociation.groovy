package fishpickle

class UserGroupAssociation {

    static constraints = {
    }
	
	boolean isAdmin=false
	static belongsTo = [user:User, group:UserGroup]
}
