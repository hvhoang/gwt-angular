package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.demo.client.directive.MyHello;
import com.asayama.gwt.angular.demo.client.filter.Reverse;
import com.asayama.gwt.angular.demo.client.service.GreetingService;

public class DemoModule extends AbstractModule {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        directive(MyHello.class);
        filter(Reverse.class);
        factory(GreetingService.class);
        controller(HttpClientDemoController.class);
        controller(OnClickEventDemoController.class);
        controller(TextInputDemoController.class);
        controller(UrlHashParameterDemoController.class);
        controller(ReverseFilterDemoController.class);
        controller(PrettifyDemoController.class);
        controller(PromiseDemoController.class);
        controller(CustomDirectiveDemoController.class);
        controller(ImageResourceDemoController.class);
    }
}
