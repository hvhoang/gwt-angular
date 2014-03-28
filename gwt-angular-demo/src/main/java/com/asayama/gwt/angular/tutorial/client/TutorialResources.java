package com.asayama.gwt.angular.tutorial.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface TutorialResources extends ClientBundle {

    static TutorialResources INSTANCE = GWT.create(TutorialResources.class);
    
}
