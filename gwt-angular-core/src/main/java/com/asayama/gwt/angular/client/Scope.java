package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSObject;


public interface Scope {
	public void digest();
}
class ScopeJSO extends JSObject implements Scope {

	protected ScopeJSO() {
	}

	@Override
	public final native void digest() /*-{
		if (!this.$$phase) {
			this.$digest();
		}
	}-*/;

}