package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Window;

public class NavbarController implements Controller {

    private static NavigationConstants CONSTANTS = GWT.create(NavigationConstants.class);

    public static final String PROJECT_VERSION = CONSTANTS.projectVersion();
    public static final String EXAMPLES = CONSTANTS.examples();
    public static final String DOWNLOADS = CONSTANTS.downloads();
    public static final String DEVELOP = CONSTANTS.develop();

    protected RouteParams routeParams;

    @Bind("pages.json")
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
        // noop
    }
    
    public String getStyleNavlinkDownloads() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/downloads") ? "active" : "";
    }

    public String getStyleNavlinkExamples() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/examples") ? "active" : "";
    }

    public String getStyleNavlinkHome() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/jumbotron") ? "active" : "";
    }

    public String getStyleNavlinkLearn() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/documentation") ? "active" : "";
    }
    
    public JSArray<String> getPageKeys() {
        return pages == null ? null : pages.keys();
    }

    public JSON getPage(String key) {
        return pages.getJSON(key);
    }
}

interface NavigationConstants extends Constants {

    @DefaultStringValue("${project.version}")
    String projectVersion();

    @DefaultStringValue("Examples")
    String examples();

    @DefaultStringValue("Downloads")
    String downloads();

    @DefaultStringValue("Develop")
    String develop();
}