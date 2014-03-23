package com.asayama.gwt.angular.tutorial.client.partials;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface TutorialPartials extends ClientBundle {

    public static final TutorialPartials INSTANCE = GWT.create(TutorialPartials.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("Introduction.html")
    public DataResource introduction();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("ProjectSetup.html")
    public DataResource projectSetup();

}
