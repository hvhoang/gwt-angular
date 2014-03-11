package com.asayama.gwt.angular.demo.client.model;

import com.asayama.gwt.core.client.JSON;


public class Tab extends JSON {

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
