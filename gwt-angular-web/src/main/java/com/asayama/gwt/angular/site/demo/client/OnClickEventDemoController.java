package com.asayama.gwt.angular.site.demo.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.user.client.Event;

public class OnClickEventDemoController implements Controller {

    // Public final fields are directly bound to AngularJS's $scope, and 
    // they are available for use in the HTML.
    
    public static final String TITLE = "Click Me";
    
    // Other fields are used to represent the state of this controller.

    private String caption = "You have not clicked me";

    @Override
    public void onControllerLoad() {
        //noop
    }

    // Public methods are automatically wired to AngularJS's $scope, and
    // they are availabe for use in the HTML.

    public void onClickTitle(Event event) {
        setCaption("Clicked at " + new Date());
    }

    public void onClickCaption(Event event) {
        setCaption("Hey!");
    }

    public String getCaption() {
        return caption;
    }
    
    public void setCaption(String caption) {
        this.caption = caption;
    }
}
