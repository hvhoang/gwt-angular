package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface TutorialResources extends ClientBundle {
    
    static final TutorialResources INSTANCE = GWT.create(TutorialResources.class);
    
    @Source("tutorial_001.png")
    ImageResource tutorial001();
    
    @Source("view/ProjectStructure.html")
    HtmlResource projectStructure();
}
