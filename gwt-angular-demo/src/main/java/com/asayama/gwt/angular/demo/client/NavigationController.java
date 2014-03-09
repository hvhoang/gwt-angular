package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public class NavigationController implements Controller {

    private static NavigationConstants CONSTANTS = GWT.create(NavigationConstants.class);

    public static final String PROJECT_NAME = CONSTANTS.projectName();
    public static final String PROJECT_DISPLAY_NAME = CONSTANTS.projectDisplayName();
    public static final String EXAMPLES = CONSTANTS.examples();
    public static final String DOWNLOAD = CONSTANTS.download();
    public static final String DEVELOP = CONSTANTS.develop();

    private Location location;
    private RouteParams routeParams;

    @Override
    public void onControllerLoad() {
    }

}

interface NavigationConstants extends Constants {
    
    @DefaultStringValue("gwt-angular")
    String projectName();
    
    @DefaultStringValue("GWT Angular")
    String projectDisplayName();
    
    @DefaultStringValue("Examples")
    String examples();
    
    @DefaultStringValue("Download")
    String download();

    @DefaultStringValue("Develop")
    String develop();
}