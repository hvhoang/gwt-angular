package com.asayama.gwt.angular.examples.client;

import java.util.Iterator;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.core.client.JSArray;


public class ExamplesController implements Controller {

    private RouteParams routeParams;
    private Location location;
    private String selectedPage = null;
    
    @Bind("examples")
    private JSArray<Page> pages = null;

    @Override
    public void onControllerLoad() {
        selectedPage = routeParams.getString("page");
        if (selectedPage == null || selectedPage.isEmpty() || getPage(selectedPage) == null) {
            location.setHashParam("page", "textInput");
        }
    }
    
    public void onClickPage(Page page) {
        location.setHashParam("page", page.getName());
    }
    
    // Getters and Setters

    public Page getPage(String name) {
        Iterator<Page> it = pages.iterator();
        while (it.hasNext()) {
            Page p = it.next();
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    public Page getSelectedPage() {
        return getPage(selectedPage);
    }
    
    public Page getNextPage() {
        Iterator<Page> it = pages.iterator();
        boolean isNextNext = false;
        while (it.hasNext()) {
            Page p = it.next();
            if (isNextNext) {
                return p;
            }
            if (p.getName().equalsIgnoreCase(selectedPage)) {
                isNextNext = true;
            }
        }
        return null;
    }
    
    public String getStylePageActive(String key) {
        return key.equalsIgnoreCase(selectedPage) ? "active" : "";
    }
}
