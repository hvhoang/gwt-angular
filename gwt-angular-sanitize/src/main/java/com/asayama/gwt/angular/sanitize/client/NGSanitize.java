package com.asayama.gwt.angular.sanitize.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

@Depends("ngSanitize")
public class NGSanitize extends Module implements EntryPoint {

    static final String CLASS = NGSanitize.class.getName();
    
    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + CLASS);
            NGSanitize module = Angular.module(this);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
