package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

public class GwtWidgetDemoController implements Controller {

    // TODO automatically export the IsWidget instance members?
    private Button button;

    @Override
    public void onControllerLoad() {
        button = new Button("This is a GWT Button");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Hello, GWT Button");
            }
        });
    }
    
    public Button getButton() {
        return button;
    }
}
