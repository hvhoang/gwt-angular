package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.demo.client.directive.GwtWidget;
import com.asayama.gwt.angular.site.demo.client.directive.MyHello;
import com.asayama.gwt.angular.site.demo.client.filter.Reverse;
import com.asayama.gwt.angular.site.demo.client.service.GreetingService;

public class DemoModule extends AbstractModule {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        directive(GwtWidget.class);
        directive(MyHello.class);
        filter(Reverse.class);
        factory(GreetingService.class);
        controller(CustomDirectiveDemoController.class);
        controller(ReverseFilterDemoController.class);
        controller(GwtWidgetDemoController.class);
        controller(HttpClientDemoController.class);
        controller(OnClickEventDemoController.class);
        controller(TextInputDemoController.class);
        controller(UrlHashParameterDemoController.class);
        controller(PrettifyDemoController.class);
        controller(PromiseDemoController.class);
        controller(ImageResourceDemoController.class);
    }
}
