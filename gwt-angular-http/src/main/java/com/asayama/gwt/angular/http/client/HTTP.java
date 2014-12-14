package com.asayama.gwt.angular.http.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;


public class HTTP extends AbstractModule implements EntryPoint {

    private static final String CLASS = HTTP.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this);
            service(HttpClient.class);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
        }
    }
}
