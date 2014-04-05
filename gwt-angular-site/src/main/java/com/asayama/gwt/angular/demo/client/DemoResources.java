package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface DemoResources extends ClientBundle {

    static final DemoResources INSTANCE = GWT.create(DemoResources.class);
    
    @Source("CustomDirectiveExample.html")
    HtmlResource customDirectiveExample();
    
    @Source("HttpClientExample.html")
    HtmlResource httpClient();

    @Source("OnClickEventExample.html")
    HtmlResource onClickEvent();

    @Source("PrettifyExample.html")
    HtmlResource prettify();

    @Source("ReverseFilterExample.html")
    HtmlResource reverseFilter();

    @Source("TextInputExample.html")
    HtmlResource textInput();

    @Source("UrlHashParameterExample.html")
    HtmlResource urlHashParameter();

    TextInput textInputResources();

    static interface TextInput extends ClientBundle {
        
        @Source("TextInputExample.html")
        public TextResource view();
        
        @Source("controller/TextInputExampleController.java")
        public TextResource controller();
        
        @DoNotEmbed
        @MimeType("text/html")
        @Source("TextInputExample.html")
        public DataResource partial();
    }

    HttpClient httpClientResources();
    
    static interface HttpClient extends ClientBundle {

        @Source("HttpClientExample.html")
        public TextResource view();
        
        @Source("controller/HttpClientExampleController.java")
        public TextResource controller();
    }

    OnClickEvent onClickEventResources();
    
    public static interface OnClickEvent extends ClientBundle {

        @Source("OnClickEventExample.html")
        public TextResource view();
        
        @Source("controller/OnClickEventExampleController.java")
        public TextResource controller();
    }

    
    ReverseFilter reverseFilterResources();
    
    static interface ReverseFilter extends ClientBundle {

        @Source("ReverseFilterExample.html")
        public TextResource view();
        
        @Source("controller/ReverseFilterExampleController.java")
        public TextResource controller();

        @Source("filter/Reverse.java")
        public TextResource filter();

        @Source("ReverseFilterModule.txt")
        public TextResource module();
    }
    
    UrlHashParameter urlHashParameterResources();

    static interface UrlHashParameter extends ClientBundle {

        @Source("UrlHashParameterExample.html")
        public TextResource view();
        
        @Source("controller/UrlHashParameterExampleController.java")
        public TextResource controller();
    }
    
    Prettify prettifyResources();

    public interface Prettify extends ClientBundle {

        @Source("PrettifyExample.html")
        public TextResource view();
        
        @Source("controller/PrettifyExampleController.java")
        public TextResource controller();
    }
    
    CustomDirectiveExampleResources customDirectiveResources();

    public interface CustomDirectiveExampleResources extends ClientBundle {

        @Source("CustomDirectiveExample.html")
        public TextResource view();

        @Source("CustomeDirectiveModule.txt")
        public TextResource module();
        
        @Source("directive/MyHello.java")
        public TextResource directive();
        
        @Source("directive/MyHello.html")
        public TextResource template();

        @Source("controller/CustomDirectiveExampleController.java")
        public TextResource controller();
    }
}
