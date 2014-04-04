package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.resources.client.ImageResource;


public class TutorialController extends AbstractMultiPageController {

    public static final ImageResource TUTORIAL_001 = TutorialResources.INSTANCE.tutorial001();
    
    public static final String SAMPLE_HTML = SamplePartials.INSTANCE.sample().getSafeUri().asString();
    
    @Bind("tutorial")
    private JSArray<Page> pages = null;
    private String defaultPageName = "introduction";

    // Getters and Setters

    @Override
    public JSArray<Page> getPages() {
        return pages;
    }

    @Override
    public void setPages(JSArray<Page> pages) {
        this.pages = pages;
    }
    
    @Override
    public String getDefaultPageName() {
        return defaultPageName;
    }
    
    @Override
    public void setDefaultPageName(String defaultPageName) {
        this.defaultPageName = defaultPageName;
    }
}
