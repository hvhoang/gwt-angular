package com.asayama.gwt.jquery.client;

import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSObject;


public class Element extends JSObject {
    
    protected Element() {
    }
    
    public final native void append(Object o) /*-{
        this.append(o);
    }-*/;

    public final native Element empty() /*-{
        return this.empty();
    }-*/;

    public final native String html() /*-{
        return this.html();
    }-*/;
    
    public final native void ready(JSClosure closure) /*-{
        this.ready(closure);
    }-*/;

    public final native String replaceWith(Object o) /*-{
        this.replaceWith(o);
    }-*/;

    public final native String text() /*-{
        return this.text();
    }-*/;

    public final native void addClass(String string) /*-{
        this.addClass(string);
    }-*/;
}