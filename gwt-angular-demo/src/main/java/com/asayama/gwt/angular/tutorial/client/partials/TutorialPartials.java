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
    @Source("introduction.html")
    public DataResource introduction();

}
