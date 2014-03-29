package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.core.client.JSArray;


public class TutorialController extends AbstractMultiPageController {

    public static final String SAMPLE_HTML = SamplePartials.INSTANCE.sample().url();
    
    @Bind("tutorial")
    private JSArray<Page> pages = null;
    private String defaultPageName = null;

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
