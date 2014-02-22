package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

/**
 * An abstract representation of AngularJS objects. Concrete implementations of
 * this class should be associated with a native AngularJS object, which must
 * be declared using {@link Bind} annotation.
 * 
 * @author kyoken74
 * @see Bind
 */
public abstract class NGObject extends JSObject implements Injectable {

	protected NGObject() {
	}

}
