package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;

class Examples extends JSON {

    protected Examples() {
    }

    final JSArray<Page> getPages() {
        return getJSArray("pages");
    }
}

class Page extends JSON {

    protected Page() {
    }

    final JSArray<Tab> getTabs() {
        return getJSArray("tabs");
    }

    final void setSelectedTab(Tab tab) {
        put("selectedTab", tab);
    }

    final Tab getSelectedTab() {
        return getJSObject("selectedTab");
    }
}

class Tab extends JSON {

    protected Tab() {
    }

    final String getDisplayName() {
        return getString("displayName");
    }

    final String getTemplate() {
        return getString("template");
    }

    final String getFilename() {
        return getString("filename");
    }

    final String getSource() {
        return getString("source");
    }

    final void setSource(String source) {
        put("source", source);
    }
}
