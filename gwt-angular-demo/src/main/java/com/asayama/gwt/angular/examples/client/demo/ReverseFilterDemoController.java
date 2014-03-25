package com.asayama.gwt.angular.examples.client.demo;

import com.asayama.gwt.angular.client.Controller;

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
public class ReverseFilterDemoController implements Controller {

    private String caption = "Hello, World!";

    @Override
    public void onControllerLoad() {
       //noop
    }
    
    public String getCaption() {
        return caption;
    }
}

