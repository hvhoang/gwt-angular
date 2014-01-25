package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;


public interface Scope  {
	public void digest();
}
class ScopeJSO extends $ implements Scope {

	protected ScopeJSO() {
	}

	@Override
	public final native void digest() /*-{
		this.$digest();
	}-*/;

}