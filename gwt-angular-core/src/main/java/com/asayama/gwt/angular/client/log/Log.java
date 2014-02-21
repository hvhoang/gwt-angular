package com.asayama.gwt.angular.client.log;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Log implements Service, NGObjectWrapper {
	
	NGLog ngo;
	
	public void log(String message) {
		ngo.log(message);
	}
	
	public void info(String message) {
		ngo.info(message);
	}
	
	public void warn(String message) {
		ngo.warn(message);
	}
	
	public void error(String message) {
		ngo.error(message);
	}
	
	public void debug(String message) {
		ngo.debug(message);
	}

	@Override
	public void wrap(NGObject ngo) {
		this.ngo = NGObject.cast(ngo);
	}
	NGLog getNGObject() {
		return ngo;
	}

}
@Bind("$log")
class NGLog extends NGObject {

	protected NGLog() {
	}

	final native void log(String message) /*-{
		this.log(message);
	}-*/;

	final native void info(String message) /*-{
		this.info(message);
	}-*/;

	final native void warn(String message) /*-{
		this.warn(message);
	}-*/;

	final native void error(String message) /*-{
		this.error(message);
	}-*/;

	final native void debug(String message) /*-{
		this.debug(message);
	}-*/;
	
}
