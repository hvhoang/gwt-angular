package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Window;

public class NavbarController implements Controller {

    public static final String PARTIAL = Partials.INSTANCE.navbar().getSafeUri().asString();

    public static final String PROJECT_GROUP_ID = DemoConstants.INSTANCE.projectGroupId();
    public static final String PROJECT_ARTIFACT_ID = DemoConstants.INSTANCE.projectArtifactId();
    public static final String PROJECT_VERSION = DemoConstants.INSTANCE.projectVersion();
    
    public static final String EXAMPLES = NavbarConstants.INSTANCE.examples();
    public static final String DOWNLOADS = NavbarConstants.INSTANCE.downloads();
    public static final String DEVELOP = NavbarConstants.INSTANCE.develop();

    @Bind("Pages.json")
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
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

interface NavbarConstants extends Constants {

    static NavbarConstants INSTANCE = GWT.create(NavbarConstants.class);

    @DefaultStringValue("Examples")
    String examples();

    @DefaultStringValue("Downloads")
    String downloads();

    @DefaultStringValue("Develop")
    String develop();
}