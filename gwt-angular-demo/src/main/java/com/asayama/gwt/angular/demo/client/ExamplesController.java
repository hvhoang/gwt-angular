package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;

public class ExamplesController implements Controller {

    protected RouteParams routeParams;
    protected Location location;
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
    }
    
    public JSArray<String> getTabKeys() {
        return getSelectedPage().getJSON("tabs").keys();
    }
    
    public JSON getTab(String key) {
        return getSelectedPage().getJSON("tabs").getJSON(key);
    }
    
    // Getters and Setters

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
