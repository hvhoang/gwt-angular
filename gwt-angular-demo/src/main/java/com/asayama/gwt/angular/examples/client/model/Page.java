package com.asayama.gwt.angular.examples.client.model;

import com.asayama.gwt.core.client.JSON;


public class Page extends JSON {
    
    public static Page create(String title, String filename) {
        Page page = create();
        page.put("title", title);
        page.put("filename", filename);
        return page;
    }
    
    protected Page() {
    }
}
