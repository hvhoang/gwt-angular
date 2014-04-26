package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.pages.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Window;

public class NavbarController implements Controller {

    public static final String NAVBAR_HTML = SiteResources.INSTANCE.navbar().getSafeUri().asString();
    public static final String FOOTER_HTML = SiteResources.INSTANCE.footer().getSafeUri().asString();

    public static final String PROJECT_GROUP_ID = ProjectConstants.INSTANCE.projectGroupId();
    public static final String PROJECT_ARTIFACT_ID = ProjectConstants.INSTANCE.projectArtifactId();
    public static final String PROJECT_VERSION = ProjectConstants.INSTANCE.projectVersion();
    public static final String PROJECT_URL = ProjectConstants.INSTANCE.projectUrl();
    
    public static final String GITHUB_SOURCE_URL = ProjectConstants.INSTANCE.githubSourceUrl();
    public static final String GITHUB_ISSUE_URL = ProjectConstants.INSTANCE.githubIssueUrl();
    
    public static final String DEVELOP = NavbarConstants.INSTANCE.develop();
    public static final String DOCUMENTATION = NavbarConstants.INSTANCE.documentation();
    public static final String DOWNLOADS = NavbarConstants.INSTANCE.downloads();
    public static final String EXAMPLES = NavbarConstants.INSTANCE.examples();
    public static final String TUTORIAL = NavbarConstants.INSTANCE.tutorial();

    @Bind("examples")
    private JSArray<Page> examples = null;

    @Bind("tutorial")
    private JSArray<Page> tutorial = null;

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

    public String getStyleNavlinkDocumentation() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/documentation") ? "active" : "";
    }
    
    public String getStyleNavlinkTutorial() {
        String hash = Window.Location.getHash();
        return hash.equalsIgnoreCase("#/tutorial") ? "active" : "";
    }
    
    public JSArray<Page> getExamples() {
        return examples;
    }
    
    public JSArray<Page> getTutorial() {
        return tutorial;
    }
}

interface NavbarConstants extends Constants {

    static NavbarConstants INSTANCE = GWT.create(NavbarConstants.class);

    @DefaultStringValue("Develop")
    String develop();

    @DefaultStringValue("Documenation")
    String documentation();

    @DefaultStringValue("Downloads")
    String downloads();

    @DefaultStringValue("Examples")
    String examples();

    @DefaultStringValue("Tutorial")
    String tutorial();
}