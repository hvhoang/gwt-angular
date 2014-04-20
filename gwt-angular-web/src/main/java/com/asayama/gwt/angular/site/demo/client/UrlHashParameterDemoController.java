package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;

public class UrlHashParameterDemoController implements Controller {

    // Injectable fields are automatically injected by the framework
    
    private RouteParams routeParams;
    private Location location;

    // Other fields are used to represent the state of this controller

    private String page;

    @Override
    public void onControllerLoad() {
        page = routeParams.getString("page");
    }

    // Public methods are automatically wired to AngularJS's $scope.

    public void onClickGo(String page) {
        location.setHashParam("page", page);
    }

    public String getName() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
}
