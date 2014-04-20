package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.pages.client.AbstractMultiPageController;
import com.asayama.gwt.angular.pages.client.Page;
import com.asayama.gwt.jsni.client.JSArray;


public class ExamplesController extends AbstractMultiPageController {

    @Bind("examples")
    private JSArray<Page> pages = null;
    private String defaultPageName = "textInput";
    
    public String getStylePageActive(String key) {
        return isPageActive(key) ? "active" : "";
    }

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
