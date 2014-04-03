package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface ExamplesResources {

    public static interface TextInputExampleResources extends ClientBundle {
        
        static final TextInputExampleResources INSTANCE = 
                GWT.create(TextInputExampleResources.class);

        @Source("view/demo/TextInputExample.html")
        public TextResource view();
        
        @Source("controller/TextInputExampleController.java")
        public TextResource controller();
        
        @DoNotEmbed
        @MimeType("text/html")
        @Source("view/demo/TextInputExample.html")
        public DataResource partial();
    }

    public static interface HttpClientExampleResources extends ClientBundle {

        static final HttpClientExampleResources INSTANCE = 
                GWT.create(HttpClientExampleResources.class);

        @Source("view/demo/HttpClientExample.html")
        public TextResource view();
        
        @Source("controller/HttpClientExampleController.java")
        public TextResource controller();
    }

    public static interface OnClickEventExampleResources extends ClientBundle {

        static final OnClickEventExampleResources INSTANCE = 
                GWT.create(OnClickEventExampleResources.class);

        @Source("view/demo/OnClickEventExample.html")
        public TextResource view();
        
        @Source("controller/OnClickEventExampleController.java")
        public TextResource controller();
    }

    public static interface ReverseFilterExampleResources extends ClientBundle {

        static final ReverseFilterExampleResources INSTANCE = 
                GWT.create(ReverseFilterExampleResources.class);

        @Source("view/demo/ReverseFilterExample.html")
        public TextResource view();
        
        @Source("controller/ReverseFilterExampleController.java")
        public TextResource controller();

        @Source("filter/Reverse.java")
        public TextResource filter();

        @Source("view/demo/ReverseFilterModule.txt")
        public TextResource module();
    }

    public static interface UrlHashParameterExampleResources extends ClientBundle {

        static final UrlHashParameterExampleResources INSTANCE = 
                GWT.create(UrlHashParameterExampleResources.class);

        @Source("view/demo/UrlHashParameterExample.html")
        public TextResource view();
        
        @Source("controller/UrlHashParameterExampleController.java")
        public TextResource controller();
    }

    public interface PrettifyExampleResources extends ClientBundle {

        static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);

        @Source("view/demo/PrettifyExample.html")
        public TextResource view();
        
        @Source("controller/PrettifyExampleController.java")
        public TextResource controller();
    }

    public interface CustomDirectiveExampleResources extends ClientBundle {

        static final CustomDirectiveExampleResources INSTANCE = GWT.create(CustomDirectiveExampleResources.class);

        @Source("view/demo/CustomDirectiveExample.html")
        public TextResource view();

        @Source("view/demo/CustomeDirectiveModule.txt")
        public TextResource module();
        
        @Source("directive/MyHello.java")
        public TextResource directive();
        
        @Source("directive/MyHello.html")
        public TextResource template();

        @Source("controller/CustomDirectiveExampleController.java")
        public TextResource controller();
    }
}
