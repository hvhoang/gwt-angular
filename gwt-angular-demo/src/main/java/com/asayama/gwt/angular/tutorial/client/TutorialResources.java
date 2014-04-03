package com.asayama.gwt.angular.tutorial.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.ImageResource;


public interface TutorialResources extends ClientBundle {
    
    static final TutorialResources INSTANCE = GWT.create(TutorialResources.class);
    
    @Source("tutorial_001.png")
    ImageResource tutorial001();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("view/ProjectStructure.html")
    DataResource projectStructure();
}
