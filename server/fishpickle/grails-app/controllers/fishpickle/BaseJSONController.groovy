package fishpickle

import grails.converters.JSON

import org.codehaus.groovy.grails.web.json.JSONObject

class BaseJSONController {

    def index() { }
	
	void renderError(List errors) {
		response.status = 500 //Internal Server Error
		render "Could not create new Group due to errors:\n ${errors}"
	}
	
	void renderObject(def obj) {
		response.status = 201 // Created
		render obj as JSON
	}
	
	void saveAndRender(def obj) {
		if(obj.save()){
			renderObject(obj)
		} else{
			renderError(obj.errors)
		}
	}
	
	boolean isIdValid(def id) {
		id != 0 && id != null && id != JSONObject.NULL
	}
}
