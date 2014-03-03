package com.asayama.gwt.angular.examples.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Event;

public class OnClickEventExample implements Controller {

    public static final String TITLE = OnClickExampleConstants.INSTANCE.title();
    
    // Other fields are used to represent the state of this controller
    private String title = TITLE;

    @Override
    public void onControllerLoad() {
    }

    // Public event handlers are automatically wired to AngularJS's $scope.
    public void onClickTitle(Event event) {
        setTitle("You clicked me at " + new Date());
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String clickable) {
        this.title = clickable;
    }

}

interface OnClickExampleConstants extends Constants {
    
    static final OnClickExampleConstants INSTANCE =
            GWT.create(OnClickExampleConstants.class);
    
    @DefaultStringValue("Click me")
    String title();
}