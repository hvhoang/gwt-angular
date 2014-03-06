package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public class JumbotronController extends AbstractController {

    private static JumbotronConstants CONSTANTS = GWT.create(JumbotronConstants.class);
    
    public static final String PROJECT_NAME = CONSTANTS.projectName();
    public static final String PROJECT_DISPLAY_NAME = CONSTANTS.projectDisplayName();
    public static final String LEARN_MORE = CONSTANTS.learnMore();
    public static final String MORE = CONSTANTS.more();
    public static final String EXAMPLES = CONSTANTS.examples();
    public static final String DOWNLOAD = CONSTANTS.download();
    public static final String DEVELOP = CONSTANTS.develop();
    
    @Override
    public void onControllerLoad() {
    }
}

interface JumbotronConstants extends Constants {
    
    @DefaultStringValue("gwt-angular")
    String projectName();
    
    @DefaultStringValue("GWT Angular")
    String projectDisplayName();
    
    @DefaultStringValue("Learn more »")
    String learnMore();
    
    @DefaultStringValue("More details »")
    String more();
    
    @DefaultStringValue("Examples")
    String examples();
    
    @DefaultStringValue("Download")
    String download();

    @DefaultStringValue("Develop")
    String develop();
}