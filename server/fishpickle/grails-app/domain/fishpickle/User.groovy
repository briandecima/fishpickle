package fishpickle

class User {

    static constraints = {
		login(blank:false, maxSize:20)
		displayName(blank:false, maxSize:50)
		password(blank:false, password:true, maxSize:20)
		email(maxSize:50)
    }
	String displayName
	String login
	String password
	String email
	
	static hasMany = [userGroupAssociations:UserGroupAssociation]
}
