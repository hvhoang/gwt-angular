package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.core.client.$;

public class Route extends $ {
	
	protected Route() {
	}
	
	public static Route create(String templateUrl) {
		return $.create().<Route>cast().setTemplateUrl(templateUrl);
	}

	public static <T extends Controller> Route create(String templateUrl, Class<T> controllerClass) {
		return create(templateUrl).setController(controllerClass);
	}
	
	public final String getTemplateUrl() {
		return getString("templateUrl");
	}
	
	public final Route setTemplateUrl(String templateUrl) {
		setString("templateUrl", templateUrl);
		return this;
	}

	public final String getController() {
		return getString("controller");
	}
	
	public final <T extends Controller> Route setController(Class<T> controllerClass) {
		setString("controller", controllerClass.getName());
		return this;
	}

}
