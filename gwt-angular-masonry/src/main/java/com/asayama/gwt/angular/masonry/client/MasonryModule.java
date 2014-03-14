package com.asayama.gwt.angular.masonry.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class MasonryModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + getClass().getName());
            Angular.module(this, "wu.masonry");
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
