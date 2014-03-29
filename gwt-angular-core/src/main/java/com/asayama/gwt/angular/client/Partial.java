package com.asayama.gwt.angular.client;

import com.google.gwt.resources.client.DataResource;



public interface Partial {

    public String name();
    public String url();

    public static class PartialDataResource implements Partial {
        final DataResource resource;
        public PartialDataResource(DataResource resource) {
            this.resource = resource;
        }
        @Override
        public String name() {
            return resource.getName();
        }
        @Override
        public String url() {
            return resource.getSafeUri().asString();
        }
    }
}
