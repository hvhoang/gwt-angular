package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterExampleResources extends ClientBundle {

    static UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);

    @Source("view/UrlHashParameterExample.html")
    HtmlResource urlHashParameter();

    @Source("view/UrlHashParameter.html")
    HtmlResource demo();

    @Source("view/UrlHashParameter.html")
    TextResource view();
    
    @Source("UrlHashParameterController.java")
    TextResource controller();
}
