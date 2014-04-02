package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.JSObject;


public class NGElement extends JSObject {
    
    protected NGElement() {
    }
    
    public final native void append(Object o) /*-{
        this.append(o);
    }-*/;
}