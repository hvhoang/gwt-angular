package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSON;


public class Template extends JSON {

    public static native Template create(String code) /*-{
        return {
            "template" : code
        };
    }-*/;
    
    protected Template() {
    }
}
