package com.asayama.gwt.angular.util.client;

import java.util.Iterator;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.jsni.client.JSArray;


public abstract class AbstractMultiPageController implements Controller {

    public static final String PAGE_NAME_PARAM = "page";
    
    private RouteParams routeParams;
    private Location location;
    private String selectedPageName = null;
    
    @Override
    public final void onControllerLoad() {
        setSelectedPageName(routeParams.getString(PAGE_NAME_PARAM));
        if (isPageSelected()) {
            getLocation().setHashParam(PAGE_NAME_PARAM, getDefaultPageName());
        }
    }
    
    public void onClickPage(Page page) {
        getLocation().setHashParam(PAGE_NAME_PARAM, page.getName());
    }
    
    public boolean isPageSelected() {
        return (getSelectedPageName() == null
                || getSelectedPageName().isEmpty()
                || getPage(getSelectedPageName()) == null);
    }
    
    public Page getPage(String name) {
        Iterator<Page> it = getPages().iterator();
        while (it.hasNext()) {
            Page p = it.next();
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    public Page getSelectedPage() {
        return getPage(getSelectedPageName());
    }
    
    public Page getNextPage() {
        Iterator<Page> it = getPages().iterator();
        boolean isNextNext = false;
        while (it.hasNext()) {
            Page p = it.next();
            if (isNextNext) {
                return p;
            }
            if (p.getName().equalsIgnoreCase(getSelectedPageName())) {
                isNextNext = true;
            }
        }
        return null;
    }
    
    public String getStylePageActive(String key) {
        return key.equalsIgnoreCase(getSelectedPageName()) ? "active" : "";
    }
    
    // Getters and Setters
    
    public abstract JSArray<Page> getPages();
    public abstract void setPages(JSArray<Page> pages);

    public abstract String getDefaultPageName();
    public abstract void setDefaultPageName(String defaultPageName);
    
    public String getSelectedPageName() {
        return selectedPageName;
    }

    public void setSelectedPageName(String selectedPageName) {
        this.selectedPageName = selectedPageName;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
}