package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.demo.client.controller.CustomDirectiveExampleController;
import com.asayama.gwt.angular.demo.client.controller.HttpClientExampleController;
import com.asayama.gwt.angular.demo.client.controller.OnClickEventExampleController;
import com.asayama.gwt.angular.demo.client.controller.PrettifyExampleController;
import com.asayama.gwt.angular.demo.client.controller.ReverseFilterExampleController;
import com.asayama.gwt.angular.demo.client.controller.TextInputExampleController;
import com.asayama.gwt.angular.demo.client.controller.UrlHashParameterExampleController;
import com.asayama.gwt.angular.demo.client.directive.MyHello;
import com.asayama.gwt.angular.demo.client.filter.Reverse;

public class DemoModule extends AbstractModule {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        directive(MyHello.class);
        filter(Reverse.class);
        controller(HttpClientExampleController.class);
        controller(OnClickEventExampleController.class);
        controller(TextInputExampleController.class);
        controller(UrlHashParameterExampleController.class);
        controller(ReverseFilterExampleController.class);
        controller(PrettifyExampleController.class);
        controller(CustomDirectiveExampleController.class);
    }
}
