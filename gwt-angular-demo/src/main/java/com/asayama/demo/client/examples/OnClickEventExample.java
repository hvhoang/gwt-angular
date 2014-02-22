package com.asayama.demo.client.examples;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.user.client.Event;

public class OnClickEventExample implements Controller {

    // Other fields are used to represent the state of this controller
    private String title;

    @Override
    public void onControllerLoad() {
        setTitle("Click me");
    }

    // Public event handlers are automatically wired to AngularJS's $scope.
    public void onClickTitle(Event event) {
        setTitle("You clicked me!");
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String clickable) {
        this.title = clickable;
    }

}
