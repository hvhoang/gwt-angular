package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;

public class Scope extends $ {

	protected Scope() {
	}

	public final native void digest() /*-{
		this.$digest();
	}-*/;
}
