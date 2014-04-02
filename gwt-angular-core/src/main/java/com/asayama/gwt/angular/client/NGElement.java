package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.JSObject;


public class NGElement extends JSObject {
    
    protected NGElement() {
    }
    
    public final native void append(Object o) /*-{
        this.append(o);
    }-*/;

    public final native void empty() /*-{
        this.empty();
    }-*/;

    public final native String html() /*-{
        return this.html();
    }-*/;

    public final native String replaceWith(Object o) /*-{
        this.replaceWith(o);
    }-*/;
}