package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.Injector.Inject;
import com.asayama.gwt.jsni.client.JSObject;

/**
 * An abstract representation of AngularJS objects. Concrete implementations of
 * this class should be associated with a native AngularJS object, which must
 * be declared using {@link Injector.Inject} annotation.
 * 
 * @author kyoken74
 * @see Injector.Inject
 */
public abstract class NGObject extends JSObject implements Injectable {

	protected NGObject() {
	}

}
