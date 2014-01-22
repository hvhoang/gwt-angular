package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.core.client.$;

public class Route extends $ {
	
	protected Route() {
	}
	
	public static native Route templateUrl(String templateUrl) /*-{
		return { 'templateUrl': templateUrl };
	}-*/;

}
