package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

/**
 * FIXME https://github.com/kyoken74/gwt-angular/issues/6
 */
public class Scope implements Service, NGObjectWrapper {

	NGScope delegate = null;
	
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
class NGScope extends JSObject {

	protected NGScope() {
	}

	public final native void digest() /*-{
		if (!this.$$phase) {
			this.$digest();
		}
	}-*/;

}