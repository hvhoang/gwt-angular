package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class NG extends Module implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.log("entering NG.onModuleLoad()");
        NG module = Angular.module(this);
        module.factory(new Q());
        module.factory(new Location());
        module.factory(new Log());
    }

}
