package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface TutorialResources extends ClientBundle {

    public static final TutorialResources INSTANCE = GWT.create(TutorialResources.class);

    @Source("view/Introduction.html")
    public HtmlResource introduction();

    @Source("view/ProjectStructure.html")
    public HtmlResource projectStructure();

    @Source("view/ProjectObjectModel.html")
    public HtmlResource projectObjectModel();

    @Source("view/GwtModuleXml.html")
    public HtmlResource gwtModuleXML();
}
