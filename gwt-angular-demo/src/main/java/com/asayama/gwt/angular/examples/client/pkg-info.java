/**
 * This package contains the GWT Angular example pages. Each page shows a live
 * demo, and accompanies it with the relevant source code. The demo code itself
 * is stored inside {@code com.asayama.gwt.angular.exmaples.client.demo }, and
 * this package is intended for page navigation and documentation.
 */
package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


interface HttpClientExampleResources extends ClientBundle {

    static final HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/HttpClientDemo.html")
    public DataResource demo();

    @Source("demo/HttpClientDemo.html")
    public TextResource view();
    
    @Source("demo/HttpClientDemoController.java")
    public TextResource controller();
}

interface OnClickEventExampleResources extends ClientBundle {

    static final OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/OnClickEventDemo.html")
    public DataResource demo();

    @Source("demo/OnClickEventDemo.html")
    public TextResource view();
    
    @Source("demo/OnClickEventDemoController.java")
    public TextResource controller();
}

interface ReverseFilterExampleResources extends ClientBundle {

    static final ReverseFilterExampleResources INSTANCE = GWT.create(ReverseFilterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/ReverseFilterDemo.html")
    public DataResource demo();

    @Source("demo/ReverseFilterDemo.html")
    public TextResource view();
    
    @Source("demo/ReverseFilterDemoController.java")
    public TextResource controller();

    @Source("demo/ReverseFilter.java")
    public TextResource filter();

    @Source("demo/ReverseFilterModule.txt")
    public TextResource module();
}

interface TextInputExampleResources extends ClientBundle {
    
    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/TextInputDemo.html")
    public DataResource demo();
    
    @Source("demo/TextInputDemo.html")
    public TextResource view();
    
    @Source("demo/TextInputDemoController.java")
    public TextResource controller();
}

interface UrlHashParameterExampleResources extends ClientBundle {

    static final UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/UrlHashParameterDemo.html")
    public DataResource demo();

    @Source("demo/UrlHashParameterDemo.html")
    public TextResource view();
    
    @Source("demo/UrlHashParameterDemoController.java")
    public TextResource controller();
}
