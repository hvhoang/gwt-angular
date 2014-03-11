package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class NG extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this, "ng");
            factory(Q.class);
            factory(Location.class);
            factory(Log.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
