package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;

public class TextInputExample implements Controller {

    // Public final fields are directly bound to AngularJS's $scope
    public static final String GREETING = "Hello";
    public static final String STRANGER = "Stranger";

    // Other fields are used to represent the state of this controller
    private String name = null;

    @Override
    public void onControllerLoad() {
        //noop
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
