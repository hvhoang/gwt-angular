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
    
    @Source("view/CustomDirectiveExample.html")
    HtmlResource customDirectiveExample();
    
    @Source("view/HttpClientExample.html")
    HtmlResource httpClient();

    @Source("view/OnClickEventExample.html")
    HtmlResource onClickEvent();

    @Source("view/PrettifyExample.html")
    HtmlResource prettify();

    @Source("view/ReverseFilterExample.html")
    HtmlResource reverseFilter();

    @Source("view/TextInputExample.html")
    HtmlResource textInput();

    @Source("view/UrlHashParameterExample.html")
    HtmlResource urlHashParameter();

    TextInput textInputResources();

    static interface TextInput extends ClientBundle {
        
        @Source("view/TextInputExample.html")
        public TextResource view();
        
        @Source("controller/TextInputExampleController.java")
        public TextResource controller();
        
        @DoNotEmbed
        @MimeType("text/html")
        @Source("view/TextInputExample.html")
        public DataResource partial();
    }

    HttpClient httpClientResources();
    
    static interface HttpClient extends ClientBundle {

        @Source("view/HttpClientExample.html")
        public TextResource view();
        
        @Source("controller/HttpClientExampleController.java")
        public TextResource controller();
    }

    OnClickEvent onClickEventResources();
    
    public static interface OnClickEvent extends ClientBundle {

        @Source("view/OnClickEventExample.html")
        public TextResource view();
        
        @Source("controller/OnClickEventExampleController.java")
        public TextResource controller();
    }

    
    ReverseFilter reverseFilterResources();
    
    static interface ReverseFilter extends ClientBundle {

        @Source("view/ReverseFilterExample.html")
        public TextResource view();
        
        @Source("controller/ReverseFilterExampleController.java")
        public TextResource controller();

        @Source("filter/Reverse.java")
        public TextResource filter();

        @Source("view/ReverseFilterModule.txt")
        public TextResource module();
    }
    
    UrlHashParameter urlHashParameterResources();

    static interface UrlHashParameter extends ClientBundle {

        @Source("view/UrlHashParameterExample.html")
        public TextResource view();
        
        @Source("controller/UrlHashParameterExampleController.java")
        public TextResource controller();
    }
    
    Prettify prettifyResources();

    public interface Prettify extends ClientBundle {

        @Source("view/PrettifyExample.html")
        public TextResource view();
        
        @Source("controller/PrettifyExampleController.java")
        public TextResource controller();
    }
    
    CustomDirectiveExampleResources customDirectiveResources();

    public interface CustomDirectiveExampleResources extends ClientBundle {

        @Source("view/CustomDirectiveExample.html")
        public TextResource view();

        @Source("view/CustomeDirectiveModule.txt")
        public TextResource module();
        
        @Source("directive/MyHello.java")
        public TextResource directive();
        
        @Source("directive/MyHello.html")
        public TextResource template();

        @Source("controller/CustomDirectiveExampleController.java")
        public TextResource controller();
    }
}
