package fishpickle

class LoginRestController {

	def renderUtil
	
    def index() { }
	
	def show = {
		if(params.loginName){
			renderUtil.renderObject(this, User.findByLogin(params.loginName))
		} else {
			renderUtil.renderError(this, "login name was not provided")
		}
	}
}
