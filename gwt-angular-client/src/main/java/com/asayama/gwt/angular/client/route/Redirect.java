package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.JS;

public class Redirect extends JS {

	protected Redirect() {
	}

	public static native Redirect redirectTo(String route) /*-{
		return { 'redirectTo': route };
	}-*/;
}
