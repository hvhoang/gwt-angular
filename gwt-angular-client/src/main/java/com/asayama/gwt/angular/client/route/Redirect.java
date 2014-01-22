package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.core.client.$;

public class Redirect extends $ {

	protected Redirect() {
	}

	public static Redirect create(String redirectTo) {
		return $.create().<Redirect>cast().setRedirectTo(redirectTo);
	}
	
	public final String getRedirectTo() {
		return getString("redirectTo");
	}
	
	public final Redirect setRedirectTo(String redirectTo) {
		setString("redirectTo", redirectTo);
		return this;
	}
	
}
