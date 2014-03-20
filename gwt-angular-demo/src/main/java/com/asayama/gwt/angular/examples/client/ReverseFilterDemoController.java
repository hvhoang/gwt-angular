package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractFilter;
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

class ReverseFilter extends AbstractFilter {

    @Override
    public String filter(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
