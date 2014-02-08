package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;


public class Scope implements Service, NGObjectWrapper {

	ScopeJSO delegate = null;
	
	public Scope digest() {
		delegate.digest();
		return this;
	}
	
	@Override
	public void wrap(NGObject ngo) {
		this.delegate = NGObject.cast(ngo);
	}

}
@Bind("$scope")
class ScopeJSO extends JSObject {

	protected ScopeJSO() {
	}

	public final native void digest() /*-{
		if (!this.$$phase) {
			this.$digest();
		}
	}-*/;

}