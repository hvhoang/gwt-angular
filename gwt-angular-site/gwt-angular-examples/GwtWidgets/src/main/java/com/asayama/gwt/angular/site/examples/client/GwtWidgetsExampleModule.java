package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.examples.client.directive.GwtWidget;
import com.google.gwt.core.client.EntryPoint;

public class GwtWidgetsExampleModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        directive(GwtWidget.class);
        controller(GwtWidgetsDemoController.class);
        controller(GwtWidgetsExampleController.class);
    }
}
