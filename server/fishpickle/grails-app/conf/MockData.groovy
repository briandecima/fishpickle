import fishpickle.User
import fishpickle.UserGroup
import fishpickle.UserGroupAssociation



class MockData {

	def static createUser(String login, String name, String password) {
		def user = new User(login:login,
			displayName: name,
			password: password)
			user.save()
			if(user.hasErrors()){
				println user.errors
			}
			user
	}
	
	def static createGroup(String name) {
		def group = new UserGroup(name:name)
			group.save()
			if(group.hasErrors()){
				println group.errors
			}
			group
	}
	
	def static createAssociation(User u, UserGroup g) {
		def assoc = new UserGroupAssociation(
			user: u,
			group: g
			)
		assoc.save()
		if(assoc.hasErrors()){
			println assoc.errors
		}
		assoc
	}
}
