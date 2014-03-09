package com.asayama.gwt.angular.demo.client.model;

import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;


public class Page extends JSON {

    protected Page() {
    }

    public final JSArray<Tab> getTabs() {
        return getJSArray("tabs");
    }

    public final void setSelectedTab(Tab tab) {
        put("selectedTab", tab);
    }

    public final Tab getSelectedTab() {
        return getJSObject("selectedTab");
    }
}
