package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.demo.client.controller.CustomDirectiveDemoController;
import com.asayama.gwt.angular.demo.client.controller.HttpClientDemoController;
import com.asayama.gwt.angular.demo.client.controller.ImageResourceDemoController;
import com.asayama.gwt.angular.demo.client.controller.OnClickEventDemoController;
import com.asayama.gwt.angular.demo.client.controller.PrettifyDemoController;
import com.asayama.gwt.angular.demo.client.controller.ReverseFilterDemoController;
import com.asayama.gwt.angular.demo.client.controller.TextInputDemoController;
import com.asayama.gwt.angular.demo.client.controller.UrlHashParameterDemoController;
import com.asayama.gwt.angular.demo.client.directive.MyHello;
import com.asayama.gwt.angular.demo.client.filter.Reverse;

public class DemoModule extends AbstractModule {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        directive(MyHello.class);
        filter(Reverse.class);
        
        controller(HttpClientDemoController.class);
        controller(OnClickEventDemoController.class);
        controller(TextInputDemoController.class);
        controller(UrlHashParameterDemoController.class);
        controller(ReverseFilterDemoController.class);
        controller(PrettifyDemoController.class);
        controller(CustomDirectiveDemoController.class);
        controller(ImageResourceDemoController.class);
    }
}
