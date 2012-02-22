import fishpickle.User
import fishpickle.UserGroup
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
		
		switch(GrailsUtil.environment){
			case "development":
			
				User u1 = MockData.createUser("user1", "John", "xxx")
				User u2 = MockData.createUser("user2", "Bill", "yyy")
				UserGroup g1 = MockData.createGroup("Admin")
				UserGroup g2 = MockData.createGroup("All Users")
				
				MockData.createAssociation(u1, g1)
				
				MockData.createAssociation(u2, g1)
				MockData.createAssociation(u2, g2)

				break
			case "production" : break
		}
    }
    def destroy = {
    }
	
	
}
