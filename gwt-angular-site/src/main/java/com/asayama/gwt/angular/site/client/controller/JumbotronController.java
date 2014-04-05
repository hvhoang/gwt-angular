package com.asayama.gwt.angular.site.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public class JumbotronController implements Controller {

    public static final ImageResource MVC = JumbotronResources.INSTANCE.mvc();

    public static final String LEARN_MORE = JumbotronConstants.INSTANCE.learnMore();
    public static final String MORE = JumbotronConstants.INSTANCE.more();
    
    @Override
    public void onControllerLoad() {
    }
}

interface JumbotronConstants extends Constants {

    static JumbotronConstants INSTANCE = GWT.create(JumbotronConstants.class);

    @DefaultStringValue("Learn more »")
    String learnMore();
    
    @DefaultStringValue("More details »")
    String more();
}

interface JumbotronResources extends ClientBundle {

    public static final JumbotronResources INSTANCE = GWT.create(JumbotronResources.class);
    
    @Source("mvc.png")
    ImageResource mvc();
}