package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public class JumbotronController implements Controller {

    private static JumbotronConstants CONSTANTS = GWT.create(JumbotronConstants.class);
    
    public static final String LEARN_MORE = CONSTANTS.learnMore();
    public static final String MORE = CONSTANTS.more();
    
    @Override
    public void onControllerLoad() {
    }
}

interface JumbotronConstants extends Constants {
    
    @DefaultStringValue("Learn more »")
    String learnMore();
    
    @DefaultStringValue("More details »")
    String more();
    
}