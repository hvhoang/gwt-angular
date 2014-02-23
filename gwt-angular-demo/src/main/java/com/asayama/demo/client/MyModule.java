package com.asayama.demo.client;

import com.asayama.demo.client.examples.HttpClientExample;
import com.asayama.demo.client.examples.OnClickEventExample;
import com.asayama.demo.client.examples.TextInputExample;
import com.asayama.demo.client.examples.UrlHashParameterExample;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.InjectionCallback;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.NG;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.angular.http.client.HttpClientModule;
import com.asayama.gwt.angular.route.client.NGRoute;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.asayama.gwt.angular.sanitize.client.NGSanitize;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

@Depends(ng = { "ngRoute", "ngSanitize", "com.asayama.gwt.angular.http.client.HttpClientModule" })
public class MyModule extends Module implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("entering MyModule.onModuleLoad");
        MyModule module = Angular.module(this);
        module.config(new RouteProvider(), new InjectionCallback<RouteProvider>() {
            @Override
            public void onInjection(RouteProvider injectable) {
                injectable
                    .when("/examples", Template.create("myapp/partials/examples.html", ExamplesController.class))
                    .otherwise(Redirect.create("/examples"));
            }
        });
        module.controller(new NavbarController());
        module.controller(new ExamplesController());
        module.controller(new TextInputExample());
        module.controller(new OnClickEventExample());
        module.controller(new UrlHashParameterExample());
        module.controller(new HttpClientExample());
        Angular.bootstrap(module, new NG(), new NGRoute(), new NGSanitize(), new HttpClientModule());
    }
}
