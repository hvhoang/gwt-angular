package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class HttpClientModule extends Module implements EntryPoint {

    static final String CLASS = HttpClientModule.class.getName();
    
    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + CLASS);
            HttpClientModule module = Angular.module(this);
            module.factory(new HttpClient());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
