package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface ExamplesResources extends ClientBundle {
    
    static ExamplesResources INSTANCE = GWT.create(ExamplesResources.class);
    
    TextInput textInput();

    static interface TextInput extends ClientBundle {
        
        @Source("view/demo/TextInputExample.html")
        public TextResource view();
        
        @Source("controller/TextInputExampleController.java")
        public TextResource controller();
        
        @DoNotEmbed
        @MimeType("text/html")
        @Source("view/demo/TextInputExample.html")
        public DataResource partial();
    }

    HttpClient httpClient();
    
    static interface HttpClient extends ClientBundle {

        @Source("view/demo/HttpClientExample.html")
        public TextResource view();
        
        @Source("controller/HttpClientExampleController.java")
        public TextResource controller();
    }

    OnClickEvent onClickEvent();
    
    public static interface OnClickEvent extends ClientBundle {

        @Source("view/demo/OnClickEventExample.html")
        public TextResource view();
        
        @Source("controller/OnClickEventExampleController.java")
        public TextResource controller();
    }

    
    ReverseFilter reverseFilter();
    
    static interface ReverseFilter extends ClientBundle {

        @Source("view/demo/ReverseFilterExample.html")
        public TextResource view();
        
        @Source("controller/ReverseFilterExampleController.java")
        public TextResource controller();

        @Source("filter/Reverse.java")
        public TextResource filter();

        @Source("view/demo/ReverseFilterModule.txt")
        public TextResource module();
    }
    
    UrlHashParameter urlHashParameter();

    static interface UrlHashParameter extends ClientBundle {

        @Source("view/demo/UrlHashParameterExample.html")
        public TextResource view();
        
        @Source("controller/UrlHashParameterExampleController.java")
        public TextResource controller();
    }
    
    Prettify prettify();

    public interface Prettify extends ClientBundle {

        @Source("view/demo/PrettifyExample.html")
        public TextResource view();
        
        @Source("controller/PrettifyExampleController.java")
        public TextResource controller();
    }
    
    CustomDirectiveExampleResources customDirective();

    public interface CustomDirectiveExampleResources extends ClientBundle {

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
