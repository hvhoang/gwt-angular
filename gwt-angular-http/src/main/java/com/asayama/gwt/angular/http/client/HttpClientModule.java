package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class HttpClientModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this);
            factory(new HttpClient());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
