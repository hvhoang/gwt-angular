package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.core.client.JSObject;

public class Route extends JSObject {
	
	protected Route() {
	}
	
	public static Route create(String templateUrl) {
		return JSObject.create().<Route>cast().setTemplateUrl(templateUrl);
	}

	public static <T extends Controller> Route create(String templateUrl, Class<T> controllerClass) {
		return create(templateUrl).setController(controllerClass);
	}
	
	public final String getTemplateUrl() {
		return getString("templateUrl");
	}
	
	public final Route setTemplateUrl(String templateUrl) {
		putString("templateUrl", templateUrl);
		return this;
	}

	public final String getController() {
		return getString("controller");
	}
	
	public final <T extends Controller> Route setController(Class<T> controllerClass) {
		putString("controller", controllerClass.getName());
		return this;
	}

}
