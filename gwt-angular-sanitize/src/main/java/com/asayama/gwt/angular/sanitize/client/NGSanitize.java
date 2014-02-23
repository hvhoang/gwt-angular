package com.asayama.gwt.angular.sanitize.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class NGSanitize extends Module implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.log("entering NGSanitize.onModuleLoad()");
        NGSanitize module = Angular.module(this);
    }

}
