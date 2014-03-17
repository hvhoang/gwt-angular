package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSON;

public class ExamplesController implements Controller {

    private RouteParams routeParams;
    private Location location;
    private String selectedPage = null;
    
    @Bind("pages.json")
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
        selectedPage = routeParams.getString("page");
        if (selectedPage == null || selectedPage.isEmpty() || pages.getJSON(selectedPage) == null) {
            location.setHashParam("page", "textInput");
        }
    }
    
    public void onClickPage(String key) {
        location.setHashParam("page", key);
    }
    
    // Getters and Setters

    public Page getSelectedPage() {
        return pages.getJSON(selectedPage);
    }
    
    public String getStylePageActive(String key) {
        return key.equalsIgnoreCase(selectedPage) ? "active" : "";
    }

}
