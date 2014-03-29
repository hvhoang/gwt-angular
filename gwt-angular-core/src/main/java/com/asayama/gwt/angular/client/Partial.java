package com.asayama.gwt.angular.client;

import com.google.gwt.resources.client.DataResource;



public class Partial {

    private DataResource resource;

    public Partial() {
    }
    
    public String name() {
        return resource == null ? null : resource.getName();
    }
    
    public String url() {
        return resource == null ? null : resource.getSafeUri().asString();
    }
    
    // Getters and Setters
    
    public DataResource getResource() {
        return resource;
    }
    
    public void setResource(DataResource resource) {
        this.resource = resource;
    }
}
