package fishpickle

class User {

	static searchable = true
	
    static constraints = { 
		login(blank:false, maxSize:20)
		displayName(blank:false, maxSize:50)
		password(blank:false, password:true, maxSize:20)
		email(nullable:true, maxSize:50)
    }
	String displayName
	String login
	String password
	String email
	
	static hasMany = [userGroupAssociations:UserGroupAssociation]
	
	List groups() {
		userGroupAssociations.collect{it.group};
    }
}
