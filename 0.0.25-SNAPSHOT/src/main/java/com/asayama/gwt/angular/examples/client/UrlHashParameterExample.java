package com.asayama.gwt.angular.examples.client;

import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.HashParam;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;

public class UrlHashParameterExample implements Controller {

    // Public final fields are directly bound to AngularJS's $scope
    public static final String TITLE = "Modify URL Hash Parameter";

    // Injectable fields are automatically injected by the framework
    private RouteParams routeParams;
    private Location location;

    // Other fields are used to represent the state of this controller
    private String name;

    @Override
    public void onControllerLoad() {
        String name = routeParams.getString("name");
        setName(name);
    }

    // Public event handlers are automatically wired to AngularJS's $scope.
    public void onClickModify(String name) {
        List<HashParam> params = new ArrayList<HashParam>();
        params.add(new HashParam("name", name));
        location.setHashParam(params);
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
