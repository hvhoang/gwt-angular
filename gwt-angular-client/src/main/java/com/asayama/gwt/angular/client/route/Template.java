package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.core.client.JSObject;

public class Template extends JSObject {
	
	protected Template() {
	}
	
	public static Template create(String templateUrl) {
		return JSObject.create().<Template>cast().setTemplateUrl(templateUrl);
	}

	public static <T extends Controller> Template create(String templateUrl, Class<T> controllerClass) {
		return create(templateUrl).setController(controllerClass);
	}
	
	public final String getTemplateUrl() {
		return getString("templateUrl");
	}
	
	public final Template setTemplateUrl(String templateUrl) {
		putString("templateUrl", templateUrl);
		return this;
	}

	public final String getController() {
		return getString("controller");
	}
	
	public final <T extends Controller> Template setController(Class<T> controllerClass) {
		putString("controller", controllerClass.getName());
		return this;
	}

}
