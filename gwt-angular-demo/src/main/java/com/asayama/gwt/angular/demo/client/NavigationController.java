package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.Constants;

public class NavigationController implements Controller {

    private static NavigationConstants CONSTANTS = GWT.create(NavigationConstants.class);

    public static final String PROJECT_NAME = CONSTANTS.projectName();
    public static final String PROJECT_VERSION = CONSTANTS.projectVersion();
    public static final String PROJECT_DISPLAY_NAME = CONSTANTS.projectDisplayName();
    public static final String EXAMPLES = CONSTANTS.examples();
    public static final String DOWNLOADS = CONSTANTS.downloads();
    public static final String DEVELOP = CONSTANTS.develop();

    // Services
    protected HttpClient http;
    protected RouteParams routeParams;

    @Bind("examplesURL")
    private String examplesURL;

    // Models
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
        // TODO https://github.com/kyoken74/gwt-angular/issues/33
        http.get(getExamplesURL(), new HttpClientCallback() {

            @Override
            public void onSuccess(Request request, Response response) {
                // TODO https://github.com/kyoken74/gwt-angular/issues/39
                pages = JSON.parse(response.getText());
            }

            @Override
            public void onError(Request request, Exception exception) {
                // TODO https://github.com/kyoken74/gwt-angular/issues/40
                GWT.log(examplesURL, exception);
            }
        });
    }
    
    public String getExamplesURL() {
        return examplesURL;
    }
    
    public JSArray<String> getPageKeys() {
        return pages.keys();
    }

    public JSON getPage(String key) {
        return pages.getJSON(key);
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