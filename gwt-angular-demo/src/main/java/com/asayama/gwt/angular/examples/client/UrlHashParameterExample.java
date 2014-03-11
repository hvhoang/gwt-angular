package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;

public class UrlHashParameterExample implements Controller {

    // Public final fields are directly bound to AngularJS's $scope
    public static final String TITLE = "Modify URL Hash Parameter";

    // Injectable fields are automatically injected by the framework
    private RouteParams routeParams;
    private Location location;

    // Other fields are used to represent the state of this controller
    private String page;

    @Override
    public void onControllerLoad() {
        page = routeParams.getString("page");
    }

    // Public event handlers are automatically wired to AngularJS's $scope.
    public void onClickModify(String page) {
        location.setHashParam("page", page);
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    public String getName() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
}
