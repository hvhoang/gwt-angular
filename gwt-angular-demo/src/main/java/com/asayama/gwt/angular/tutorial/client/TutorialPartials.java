package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.shared.GWT;


public interface TutorialPartials extends Partials {

    public static final TutorialPartials INSTANCE = GWT.create(TutorialPartials.class);

    @Resource("Tutorial.html")
    public Partial tutorial();
    
    @Resource("Introduction.html")
    public Partial introduction();

    @Resource("ProjectStructure.html")
    public Partial projectStructure();

    @Resource("ProjectObjectModel.html")
    public Partial projectObjectModel();

    @Resource("GwtModuleXml.html")
    public Partial gwtModuleXML();
}
