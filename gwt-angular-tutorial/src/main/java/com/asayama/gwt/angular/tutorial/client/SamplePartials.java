package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.client.GWT;


public interface SamplePartials extends Partials {

    public static final SamplePartials INSTANCE = GWT.create(SamplePartials.class);
    
    @Resource("Sample.html")
    public Partial sample();
}
