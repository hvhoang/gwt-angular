package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.JS;

public class Route extends JS {
	
	protected Route() {
	}
	
	public static native Route templateUrl(String templateUrl) /*-{
		return { 'templateUrl': templateUrl };
	}-*/;

}
