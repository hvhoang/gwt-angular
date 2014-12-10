package com.asayama.gwt.angular.client.log;

import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.Service;
import com.google.gwt.core.client.JavaScriptObject;

public class Log implements Service {

    @Injector.Inject
    private NGLog ngo;

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
}

@Injector.Bind("$log")
class NGLog extends JavaScriptObject {

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
