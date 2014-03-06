package com.asayama.gwt.angular.examples.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.user.client.Event;

public class OnClickEventExample implements Controller {

    // Represents the state of this controller
    private String caption = "Click Me";

    @Override
    public void onControllerLoad() {
        //noop
    }

    // Public event handlers are automatically wired to AngularJS's $scope.
    
    public void onClickTitle(Event event) {
        setCaption("You clicked me at " + new Date());
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.
    
    public String getCaption() {
        return caption;
    }
    
    public void setCaption(String clickable) {
        this.caption = clickable;
    }
}
