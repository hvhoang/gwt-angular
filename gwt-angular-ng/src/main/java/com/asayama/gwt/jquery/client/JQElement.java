package com.asayama.gwt.jquery.client;

import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSObject;


public class JQElement extends JSObject {
    
    protected JQElement() {
    }

    public final native JQElement addClass(String string) /*-{
        return this.addClass(string);
    }-*/;
    
    public final native JQElement append(Object o) /*-{
        return this.append(o);
    }-*/;

    public final native String attr(String key) /*-{
        return this.attr(key);
    }-*/;

    public final native JQElement attr(String key, String value) /*-{
        return this.attr(key, value);
    }-*/;

    public final native JQElement empty() /*-{
        return this.empty();
    }-*/;

    public final native JQElement find(String selector) /*-{
        return this.find(selector);
    }-*/;

    public final native String html() /*-{
        return this.html();
    }-*/;
    
    public final native JQElement ready(JSClosure closure) /*-{
        return this.ready(closure);
    }-*/;

    public final native JQElement removeClass(String string) /*-{
        return this.removeClass(string);
    }-*/;
    
    public final native String replaceWith(Object o) /*-{
        this.replaceWith(o);
    }-*/;

    public final native String text() /*-{
        return this.text();
    }-*/;
}