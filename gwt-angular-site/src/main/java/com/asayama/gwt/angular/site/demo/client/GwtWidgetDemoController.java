package com.asayama.gwt.angular.site.demo.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.datepicker.client.DatePicker;

public class GwtWidgetDemoController implements Controller {

    // TODO automatically export the IsWidget instance members?
    private Button button;
    private DatePicker datePicker;

    @Override
    public void onControllerLoad() {
        button = createButton();
        datePicker = createDatePicker();
    }
    
    private Button createButton() {
        Button button = new Button("This is a GWT Button");
        button.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                Window.alert("You clicked GWT Button");
            }
        });
        return button;
    }

    private DatePicker createDatePicker() {
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(new Date(), false);
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

            public void onValueChange(ValueChangeEvent<Date> event) {
                Date date = event.getValue();
                Window.alert("You selected " + date);
            }
        });
        return datePicker;
    }
    
    // Getters and Setters
    
    public Button getButton() {
        return button;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }
}
