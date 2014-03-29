package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;

/**
 * google-code-prettify GWT Angular filter.
 * <p>
 * Include the following <code>inherits</code> statement in your gwt.xml module
 * descriptor.
 * </p>
 * <pre>{@code 
 * <inherits name="com.asayama.gwt.angular.prettify.PrettifyModule" />
 * }</pre>
 * @author kyoken74
 */
interface PrettifyExampleResources extends ClientBundle {

    static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/PrettifyDemo.html")
    public DataResource demo();

    @Source("demo/PrettifyDemo.html")
    public TextResource html();
    
    @Source("PrettifyExampleResources.java")
    public TextResource java();
}
