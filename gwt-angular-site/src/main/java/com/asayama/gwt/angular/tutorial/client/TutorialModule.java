package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.client.controller.TutorialController;
import com.asayama.gwt.angular.tutorial.client.controller.IntroductionController;
import com.asayama.gwt.angular.tutorial.client.controller.ProjectStructureController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;


public class TutorialModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("tutorial", getPages());
        
        controller(TutorialController.class);

        controller(SampleController.class);
        controller(IntroductionController.class);
        controller(ProjectStructureController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Introduction", TutorialResources.INSTANCE.introduction()));
        pages.add(Page.create("Project Structure", TutorialResources.INSTANCE.projectStructure()));
        pages.add(Page.create("Project Object Model", TutorialResources.INSTANCE.projectObjectModel()));
        pages.add(Page.create("GWT Module XML", TutorialResources.INSTANCE.gwtModuleXML()));
       return pages;
    }
}