package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class UrlHashParameterExampleController implements Controller {

    public static final String HTML = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResource.INSTANCE.html().getText());
    public static final String JAVA = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResource.INSTANCE.java().getText());

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
