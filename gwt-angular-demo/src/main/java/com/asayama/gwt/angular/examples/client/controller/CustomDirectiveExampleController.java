package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;


public class CustomDirectiveExampleController implements Controller {

    private String name = null;
    
    @Override
    public void onControllerLoad() {
        this.name = "World";
    }
    
    // Getter and Setter
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
