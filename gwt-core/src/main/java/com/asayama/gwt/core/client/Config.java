package com.asayama.gwt.core.client;


public class Config extends JSON {
    
    public static native <T extends JSObject> T eval(String expr) /*-{
        return eval('('+expr+')');
    }-*/;

    protected Config() {
    }
}
