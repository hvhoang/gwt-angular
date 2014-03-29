package com.asayama.gwt.angular.util.client;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.resources.client.DataResource;


public class Page extends JSON {
    
    @Deprecated
    public static Page create(String title, DataResource partial) {
        return create(title, partial.getName(), partial.getSafeUri().asString());
    }
    
    public static Page create(String title, Partial partial) {
        return create(title, partial.name(), partial.url());
    }

    public static Page create(String title, String name, String url) {
        Page page = create();
        page.put("name", name);
        page.put("title", title);
        page.put("url", url);
        return page;
    }
    
    protected Page() {
    }
    
    public final String getName() {
        return getString("name");
    }
}
