package com.asayama.gwt.angular.examples.client.model;

import com.asayama.gwt.core.client.JSON;
import com.google.gwt.resources.client.DataResource;


public class Page extends JSON {
    
    public static Page create(String title, DataResource partial) {
        Page page = create();
        page.put("name", partial.getName());
        page.put("title", title);
        page.put("filename", partial.getSafeUri().asString());
        return page;
    }
    
    protected Page() {
    }
    
    public final String getName() {
        return getString("name");
    }
}
