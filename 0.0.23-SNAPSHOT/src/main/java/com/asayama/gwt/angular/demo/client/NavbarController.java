package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;

public class NavbarController implements Controller {

    private Location location;
    private RouteParams routeParams;

    @Override
    public void onControllerLoad() {
    }

    public String getStyleNavlinkHome() {
        String hash = Window.Location.getHash();
        GWT.log("hash=" + hash);
        return hash.equalsIgnoreCase("#/jumbotron") ? "active" : "";
    }

    public String getStyleNavlinkLearn() {
        String hash = Window.Location.getHash();
        GWT.log("hash=" + hash);
        return hash.equalsIgnoreCase("#/documentation") ? "active" : "";
    }

    public String getStyleNavlinkExamples() {
        String hash = Window.Location.getHash();
        GWT.log("hash=" + hash);
        return hash.equalsIgnoreCase("#/examples") ? "active" : "";
    }
}
