package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

@Depends("ng")
public class NG extends Module implements EntryPoint {

    static final String CLASS = NG.class.getName();
    
    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + CLASS);
            NG module = Angular.module(this);
            module.factory(new Q());
            module.factory(new Location());
            module.factory(new Log());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
