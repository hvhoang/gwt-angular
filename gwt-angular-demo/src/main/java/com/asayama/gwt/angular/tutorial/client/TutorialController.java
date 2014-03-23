package com.asayama.gwt.angular.tutorial.client;

import java.util.Iterator;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.examples.client.model.Page;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSON;


public class TutorialController implements Controller {

    public static final String SAMPLE_HTML =
            SamplePartials.INSTANCE.sample().getSafeUri().asString();
    
    private RouteParams routeParams;
    private Location location;
    private String selectedPage = null;
    
    @Bind("tutorial")
    private JSON pages = null;

    @Override
    public void onControllerLoad() {
        selectedPage = routeParams.getString("page");
        if (selectedPage == null || selectedPage.isEmpty() || pages.getJSON(selectedPage) == null) {
            location.setHashParam("page", "introduction");
        }
    }
    
    public void onClickPage(String key) {
        location.setHashParam("page", key);
    }
    
    // Getters and Setters

    public Page getSelectedPage() {
        return pages.getJSON(selectedPage);
    }
    
    public Page getNextPage() {
        Iterator<String> keys = pages.keys().iterator();
        boolean isNextNext = false;
        while (keys.hasNext()) {
            String key = keys.next();
            if (isNextNext) {
                return pages.getJSON(key);
            }
            if (key.equalsIgnoreCase(selectedPage)) {
                isNextNext = true;
            }
        }
        return null;
    }
    
    public String getStylePageActive(String key) {
        return key.equalsIgnoreCase(selectedPage) ? "active" : "";
    }
}
