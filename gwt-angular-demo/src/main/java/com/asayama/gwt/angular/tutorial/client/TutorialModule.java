package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.model.Page;
import com.asayama.gwt.angular.examples.client.model.Pages;
import com.asayama.gwt.angular.tutorial.client.partials.TutorialPartials;
import com.google.gwt.core.client.EntryPoint;


public class TutorialModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("tutorial", getPages());
        controller(SampleController.class);
        controller(TutorialController.class);
    }
    
    private Pages getPages() {
        Pages pages = Pages.create();
        pages.put("introduction", Page.create("Introduction",
                TutorialPartials.INSTANCE.introduction().getSafeUri().asString()));
        pages.put("projectSetup", Page.create("Project Setup",
                TutorialPartials.INSTANCE.projectSetup().getSafeUri().asString()));
       return pages;
    }
}