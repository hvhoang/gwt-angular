package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public class IncludeRemoteDirective extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        return null;//IncludeRemoteDirectiveResource.INSTANCE.template();
    }
    
    @Override
    public DataResource getPartial() {
        return IncludeRemoteDirectiveResource.INSTANCE.partial();
    }
}

interface IncludeRemoteDirectiveResource extends ClientBundle {
    
    static final IncludeRemoteDirectiveResource INSTANCE =
            GWT.create(IncludeRemoteDirectiveResource.class);
    
    @Source("IncludeRemoteDirective.java")
    TextResource template();
    
    @DoNotEmbed
    @MimeType("text/plain")
    @Source("IncludeRemoteDirective.java")
    DataResource partial();
}