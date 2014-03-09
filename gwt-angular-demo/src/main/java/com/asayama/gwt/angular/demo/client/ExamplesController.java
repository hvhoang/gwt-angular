package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;
import com.asayama.gwt.core.client.util.Objects;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

public class ExamplesController implements Controller {

    // Services
    protected HttpClient http;
    protected RouteParams routeParams;
    protected Location location;
    
    @Bind("examplesURL")
    private String examplesURL;

    // Models
    private String selectedPage = null;
    private String selectedTab = null;
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
        //TODO https://github.com/kyoken74/gwt-angular/issues/33
        selectedPage = Objects.coalesce(routeParams.getString("page"), "textInput");
        selectedTab = Objects.coalesce(routeParams.getString("tab"), "demo");
        http.get(getExamplesURL(), new HttpClientCallback() {

            @Override
            public void onSuccess(Request request, Response response) {
                //TODO https://github.com/kyoken74/gwt-angular/issues/39
                pages = JSON.parse(response.getText());
            }

            @Override
            public void onError(Request request, Exception exception) {
                //TODO https://github.com/kyoken74/gwt-angular/issues/40
                GWT.log(examplesURL, exception);
            }
        });
    }
    
    public void onClickPage(String key) {
        location.setHashParam("page", key);
    }
    
    public void onClickTab(String key) {
        location.setHashParam("tab", key);
    }
    
    public JSArray<String> getTabKeys() {
        return getSelectedPage().getJSON("tabs").keys();
    }
    
    public JSON getTab(String key) {
        return getSelectedPage().getJSON("tabs").getJSON(key);
    }
    
    // Getters and Setters

    public String getExamplesURL() {
        return examplesURL;
    }
    
    public JSON getSelectedPage() {
        return pages.getJSON(selectedPage);
    }
    
    public String getStylePageActive(String key) {
        return key.equalsIgnoreCase(selectedPage) ? "active" : "";
    }

    public String getStyleTabActive(String key) {
        return key.equalsIgnoreCase(selectedTab) ? "active" : "";
    }
}
