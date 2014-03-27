package com.asayama.gwt.angular.tutorial.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface TutorialResources extends ClientBundle {

    static TutorialResources INSTANCE = GWT.create(TutorialResources.class);
    
    @Source("pom-dependencies.xml")
    TextResource pomDependencies();

    @Source("pom-gwt-maven-plugin.xml")
    TextResource pomGwtMavenPlugin();
}
