package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public class NavigationController implements Controller {

    private static NavigationConstants CONSTANTS = GWT.create(NavigationConstants.class);

    public static final String PROJECT_NAME = CONSTANTS.projectName();
    public static final String PROJECT_VERSION = CONSTANTS.projectVersion();
    public static final String PROJECT_DISPLAY_NAME = CONSTANTS.projectDisplayName();
    public static final String EXAMPLES = CONSTANTS.examples();
    public static final String DOWNLOADS = CONSTANTS.downloads();
    public static final String DEVELOP = CONSTANTS.develop();

    @Override
    public void onControllerLoad() {
    }

}

interface NavigationConstants extends Constants {
    
    @DefaultStringValue("gwt-angular")
    String projectName();
    
    @DefaultStringValue("${project.version}")
    String projectVersion();
    
    @DefaultStringValue("GWT Angular")
    String projectDisplayName();
    
    @DefaultStringValue("Examples")
    String examples();
    
    @DefaultStringValue("Downloads")
    String downloads();

    @DefaultStringValue("Develop")
    String develop();
}