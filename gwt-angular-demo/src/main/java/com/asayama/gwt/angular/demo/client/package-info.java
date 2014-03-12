/**
 * @author kyoken74
 */
package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;

class Page extends JSON {

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

class Tab extends JSON {

    protected Tab() {
    }

    public final String getDisplayName() {
        return getString("displayName");
    }

    public final String getTemplate() {
        return getString("template");
    }

    public final String getFilename() {
        return getString("filename");
    }

    public final String getSource() {
        return getString("source");
    }

    public final void setSource(String source) {
        put("source", source);
    }
}
