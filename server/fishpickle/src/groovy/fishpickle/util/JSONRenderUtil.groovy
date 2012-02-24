package fishpickle.util

import grails.converters.JSON

import java.util.List

import org.codehaus.groovy.grails.web.json.JSONObject

class JSONRenderUtil {

	public void renderError(def controller, List errors) {
		controller.response.status = 500 //Internal Server Error
		controller.render "Could not create new Group due to errors:\n ${errors}"
	}
	
	public void renderObject(def controller, def obj) {
		controller.response.status = 201 // Created
		controller.render obj as JSON
	}
	
	public void saveAndRender(def controller, def obj) {
		if(obj.save()){
			renderObject(controller, obj)
		} else{
			renderError(controller, obj.errors)
		}
	}
	
	public boolean isIdValid(def id) {
		id != 0 && id != null && id != JSONObject.NULL
	}
}
