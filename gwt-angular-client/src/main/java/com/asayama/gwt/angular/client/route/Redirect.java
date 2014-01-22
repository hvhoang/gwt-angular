package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.core.client.$;

public class Redirect extends $ {

	protected Redirect() {
	}

	public static native Redirect redirectTo(String route) /*-{
		return { 'redirectTo': route };
	}-*/;
}
