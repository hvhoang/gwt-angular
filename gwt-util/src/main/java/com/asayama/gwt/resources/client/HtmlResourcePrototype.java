package com.asayama.gwt.resources.client;

import com.google.gwt.safehtml.shared.SafeUri;

public class HtmlResourcePrototype implements HtmlResource {

    private final String name;
    private final SafeUri uri;

    public HtmlResourcePrototype(String name, SafeUri uri) {
        this.name = name;
        this.uri = uri;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SafeUri getSafeUri() {
        return uri;
    }
}
