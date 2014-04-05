package com.asayama.gwt.angular.tutorial.client.view;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface TutorialPartials extends ClientBundle {

    public static final TutorialPartials INSTANCE = GWT.create(TutorialPartials.class);

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
