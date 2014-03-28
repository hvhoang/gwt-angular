package com.asayama.gwt.angular.tutorial.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface TutorialPartials extends ClientBundle {

    public static final TutorialPartials INSTANCE = GWT.create(TutorialPartials.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("Tutorial.html")
    public DataResource tutorial();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("Introduction.html")
    public DataResource introduction();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("ProjectStructure.html")
    public DataResource projectStructure();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("ProjectObjectModel.html")
    public DataResource projectObjectModel();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("GwtModuleXml.html")
    public DataResource gwtModuleXML();

}
