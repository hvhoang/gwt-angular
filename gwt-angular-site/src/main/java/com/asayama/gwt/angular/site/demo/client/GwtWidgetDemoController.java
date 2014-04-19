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
    private Date date;

    @Override
    public void onControllerLoad() {

        button = new Button("This is a GWT Button");
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Hello, GWT Button");
            }
        });

        datePicker = new DatePicker();
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

            public void onValueChange(ValueChangeEvent<Date> event) {
                GwtWidgetDemoController.this.date = event.getValue();
            }
        });
        datePicker.setValue(new Date(), true);
    }

    public Button getButton() {
        return button;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }
    
    public Date getDate() {
        return date;
    }
}
