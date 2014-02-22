package com.asayama.gwt.angular.client;

/**
 * Provides interfaces for wrapping native AngularJS objects (represented by
 * {@link NGObject} into GWT Java objects.
 * 
 * @author kyoken74
 */
public interface NGObjectWrapper<T extends NGObject> {
	void wrap(NGObject ngo);
	T getNGObject();
}
