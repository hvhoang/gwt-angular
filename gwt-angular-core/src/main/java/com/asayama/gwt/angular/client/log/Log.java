package com.asayama.gwt.angular.client.log;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Log implements Service, NGObjectWrapper<NGLog> {

    NGLog ngo;

    public void log(String message) {
        getNGObject().log(message);
    }

    public void info(String message) {
        getNGObject().info(message);
    }

    public void warn(String message) {
        getNGObject().warn(message);
    }

    public void error(String message) {
        getNGObject().error(message);
    }

    public void debug(String message) {
        getNGObject().debug(message);
    }

    @Override
    public void wrap(NGObject ngo) {
        this.ngo = NGObject.cast(ngo);
    }

    @Override
    public NGLog getNGObject() {
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
