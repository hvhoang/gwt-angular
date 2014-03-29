package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.resources.client.DataResource;

public class Template extends JSObject {
	
	protected Template() {
	}
	
    public static <T extends Controller> Template create(Partial partial, Class<T> controllerClass) {
        String templateUrl = partial.url();
        return create(templateUrl).setController(controllerClass);
    }

    public static Template create(String templateUrl) {
		return JSObject.create().<Template>cast().setTemplateUrl(templateUrl);
	}

//	//TODO Should this accept DataResource instead of templateUrl?
//    public static <T extends Controller> Template create(String templateUrl, Class<T> controllerClass) {
//        return create(templateUrl).setController(controllerClass);
//    }
    
	@Deprecated
    public static <T extends Controller> Template create(DataResource partial, Class<T> controllerClass) {
        String templateUrl = partial.getSafeUri().asString();
        return create(templateUrl).setController(controllerClass);
    }
    
	public final String getTemplateUrl() {
		return $string("templateUrl");
	}
	
	//TODO Should we support this as well as DataResource? Or, just DataResource?
	public final Template setTemplateUrl(String templateUrl) {
		$string("templateUrl", templateUrl);
		return this;
	}

	public final String getController() {
		return $string("controller");
	}
	
	public final <T extends Controller> Template setController(Class<T> controllerClass) {
		$string("controller", controllerClass.getName());
		return this;
	}

}
