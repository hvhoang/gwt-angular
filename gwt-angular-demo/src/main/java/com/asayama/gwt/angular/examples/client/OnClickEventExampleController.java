package com.asayama.gwt.angular.examples.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Event;

public class OnClickEventExampleController implements Controller {

    public static final String DEMO_URL =
            OnClickEventExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.java().getText());

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

interface OnClickEventExampleResources extends ClientBundle {

    static final OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("OnClickEventExampleDemo.html")
    public DataResource demo();

    @Source("OnClickEventExampleDemo.html")
    public TextResource html();
    
    @Source("OnClickEventExampleController.java")
    public TextResource java();
}
