package fishpickle

class LoginRestController {

	def renderUtil
	
    def index() { }
	
	/**
	 * returns the user given the loginName<br>
	 * url: <b>/rest/login/{loginName}</b><br>
	 */
	def show = {
		if(params.loginName){
			renderUtil.renderObject(this, User.findByLogin(params.loginName))
		} else {
			renderUtil.renderError(this, "login name was not provided")
		}
	}
}
