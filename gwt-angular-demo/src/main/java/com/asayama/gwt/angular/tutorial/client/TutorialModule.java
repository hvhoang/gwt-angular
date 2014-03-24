package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.tutorial.client.partials.TutorialPartials;
import com.asayama.gwt.angular.util.client.model.Page;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.client.EntryPoint;


public class TutorialModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("tutorial", getPages());
        controller(SampleController.class);
        controller(TutorialController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Introduction",
                TutorialPartials.INSTANCE.introduction()));
        pages.add(Page.create("Project Setup",
                TutorialPartials.INSTANCE.projectSetup()));
       return pages;
    }
}