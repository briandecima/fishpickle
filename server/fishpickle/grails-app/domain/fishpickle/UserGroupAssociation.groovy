package fishpickle

class UserGroupAssociation {

	static constraints = {
	}

	boolean isAdmin=false
	User user
	UserGroup group

	static UserGroupAssociation link(user, group, isAdmin) {
		def m = UserGroupAssociation.findByUserAndGroup(user, group)
		if (!m) {
			m = new UserGroupAssociation(isAdmin:isAdmin)
			user?.addToUserGroupAssociations(m)
			group?.addToUserGroupAssociations(m)
			m.save()
		}
		return m
	}

	static void unlink(user, group) {
		def m = UserGroupAssociation.findByUserAndGroup(user, group)
		if (m) {
			user?.removeFromUserGroupAssociations(m)
			group?.removeFromUserGroupAssociations(m)
			m.delete()
		}
	}
}
