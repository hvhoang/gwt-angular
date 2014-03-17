package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class TextInputExampleController implements Controller {

    public static final String DEMO_URL =
            TextInputExampleResource.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResource.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResource.INSTANCE.java().getText());

    // Public final fields are directly bound to AngularJS's $scope, and they 
    // are available for use in the HTML.
    
    public static final String GREETING = "Hello";
    public static final String STRANGER = "Stranger";

    // Other fields are used to represent the state of this controller.
    
    private String name = null;

    @Override
    public void onControllerLoad() {
        //noop
    }

    // Public methods are automatically wired to AngularJS's $scope, and
    // they are availabe for use in the HTML.
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}