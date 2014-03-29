package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.core.client.JSObject;

@Deprecated
public class Redirect extends JSObject {

	protected Redirect() {
	}

	public static Redirect create(String redirectTo) {
		return Redirect.<Redirect>create().setRedirectTo(redirectTo);
	}
	
	public final String getRedirectTo() {
		return $string("redirectTo");
	}
	
	public final Redirect setRedirectTo(String redirectTo) {
		$string("redirectTo", redirectTo);
		return this;
	}
	
}
