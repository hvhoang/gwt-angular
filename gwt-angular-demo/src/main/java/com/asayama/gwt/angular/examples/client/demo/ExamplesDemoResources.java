package com.asayama.gwt.angular.examples.client.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface ExamplesDemoResources {

    public static interface HttpClientExampleResources extends ClientBundle {

        static final HttpClientExampleResources INSTANCE = 
                GWT.create(HttpClientExampleResources.class);

        @Source("HttpClientDemo.html")
        public TextResource view();
        
        @Source("HttpClientDemoController.java")
        public TextResource controller();
    }

    public static interface OnClickEventExampleResources extends ClientBundle {

        static final OnClickEventExampleResources INSTANCE = 
                GWT.create(OnClickEventExampleResources.class);

        @Source("OnClickEventDemo.html")
        public TextResource view();
        
        @Source("OnClickEventDemoController.java")
        public TextResource controller();
    }

    public static interface ReverseFilterExampleResources extends ClientBundle {

        static final ReverseFilterExampleResources INSTANCE = 
                GWT.create(ReverseFilterExampleResources.class);

        @Source("ReverseFilterDemo.html")
        public TextResource view();
        
        @Source("ReverseFilterDemoController.java")
        public TextResource controller();

        @Source("ReverseFilter.java")
        public TextResource filter();

        @Source("ReverseFilterModule.txt")
        public TextResource module();
    }

    public static interface TextInputExampleResources extends ClientBundle {
        
        static final TextInputExampleResources INSTANCE = 
                GWT.create(TextInputExampleResources.class);

        @Source("TextInputDemo.html")
        public TextResource view();
        
        @Source("TextInputDemoController.java")
        public TextResource controller();
    }

    public static interface UrlHashParameterExampleResources extends ClientBundle {

        static final UrlHashParameterExampleResources INSTANCE = 
                GWT.create(UrlHashParameterExampleResources.class);

        @Source("UrlHashParameterDemo.html")
        public TextResource view();
        
        @Source("UrlHashParameterDemoController.java")
        public TextResource controller();
    }

    public interface PrettifyExampleResources extends ClientBundle {

        static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);

        @Source("PrettifyDemo.html")
        public TextResource view();
        
        @Source("PrettifyDemoController.java")
        public TextResource controller();
    }
}
