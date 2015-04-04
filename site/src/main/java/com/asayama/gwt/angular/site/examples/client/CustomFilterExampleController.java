package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractController;

/**
 * When you create a custom filter, such as ReverseFilter, you must register it
 * with your module. In this example, we associate the ReverseFilter with a name
 * "reverse".
 * 
 * <pre>{@code 
 * public class SomeExampleModule extends AbstractModule implements EntryPoint {
 *   public void onModuleLoad() {
 *     Angular.module(this);
 *     this.filter("reverse", new ReverseFilter());
 *     this.controller(ReverseFilterDemoController.class);
 *   }
 * }</pre>
 * @author kyoken74
 */
public class CustomFilterExampleController extends AbstractController {

    private String caption = "Hello, World!";

    public String getCaption() {
        return caption;
    }
}
