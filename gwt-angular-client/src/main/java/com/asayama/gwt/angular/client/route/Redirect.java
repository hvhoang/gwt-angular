package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.core.client.JSObject;

public class Redirect extends JSObject {

	protected Redirect() {
	}

	public static Redirect create(String redirectTo) {
		return JSObject.create().<Redirect>cast().setRedirectTo(redirectTo);
	}
	
	public final String getRedirectTo() {
		return getString("redirectTo");
	}
	
	public final Redirect setRedirectTo(String redirectTo) {
		putString("redirectTo", redirectTo);
		return this;
	}
	
}
