package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.demo.client.model.Tab;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

public class ExamplesController implements Controller {

    private HttpClient http;
    private RouteParams routeParams;
    private Location location;
    private String selectedPage = null;
    private String selectedTab = null;
    
    @Bind("pages.json")
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
        //TODO https://github.com/kyoken74/gwt-angular/issues/42
        selectedPage = routeParams.getString("page");
        if (selectedPage == null || selectedPage.isEmpty()) {
            location.setHashParam("page", "textInput");
        }
        selectedTab = routeParams.getString("tab");
        if (selectedTab == null || selectedTab.isEmpty()) {
            location.setHashParam("tab", "demo");
        }
    }
    
    public void onClickPage(String key) {
        location.setHashParam("page", key);
    }
    
    public void onClickTab(String key) {
        location.setHashParam("tab", key);
        final Tab tab = getTab(key);
        if (tab.getString("source") == null) {
            http.get(tab.getFilename(), new HttpClientCallback() {
                @Override
                public void onSuccess(Request request, Response response) {
                    tab.setSource(response.getText());
                }
                @Override
                public void onError(Request request, Exception exception) {
                    //TODO https://github.com/kyoken74/gwt-angular/issues/40
                    GWT.log(request.toString(), exception);
                }
            });
        }
    }
    
    public JSArray<String> getTabKeys() {
        return getSelectedPage().getJSON("tabs").keys();
    }
    
    public Tab getTab(String key) {
        return getSelectedPage().getJSON("tabs").getJSON(key);
    }
    
    // Getters and Setters

    public Tab getSelectedPage() {
        return pages.getJSON(selectedPage);
    }
    
    public String getStylePageActive(String key) {
        return key.equalsIgnoreCase(selectedPage) ? "active" : "";
    }

    public String getStyleTabActive(String key) {
        return key.equalsIgnoreCase(selectedTab) ? "active" : "";
    }
}
