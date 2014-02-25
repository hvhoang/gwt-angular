package com.asayama.demo.examples.client.controllers;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public class TextInputExample implements Controller {

    // Public final fields are directly bound to AngularJS's $scope
    public static final String GREETING = TextInputExampleConstants.INSTANCE.greeting();
    public static final String STRANGER = TextInputExampleConstants.INSTANCE.stranger();

    // Other fields are used to represent the state of this controller
    private String name = null;

    @Override
    public void onControllerLoad() {
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}

interface TextInputExampleConstants extends Constants {

    static final TextInputExampleConstants INSTANCE = 
            GWT.create(TextInputExampleConstants.class);

    @DefaultStringValue("Hello")
    String greeting();

    @DefaultStringValue("Stranger")
    String stranger();
}