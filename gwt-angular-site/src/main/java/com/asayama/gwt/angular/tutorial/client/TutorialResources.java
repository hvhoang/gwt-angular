package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface TutorialResources extends ClientBundle {

    public static final TutorialResources INSTANCE = GWT.create(TutorialResources.class);

    @Source("ProjectStructure.png")
    public ImageResource projectStructureImage();
    
    @Source("Tutorial.html")
    public HtmlResource tutorial();
    
    @Source("Introduction.html")
    public HtmlResource introduction();

    @Source("ProjectStructure.html")
    public HtmlResource projectStructure();

    @Source("ProjectObjectModel.html")
    public HtmlResource projectObjectModel();

    @Source("GwtModuleXml.html")
    public HtmlResource gwtModuleXML();
}
