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
    
    @Source("CustomDirectiveDemo.html")
    HtmlResource customDirectiveExample();
    
    @Source("HttpClientDemo.html")
    HtmlResource httpClient();

    @Source("OnClickEventDemo.html")
    HtmlResource onClickEvent();

    @Source("PrettifyDemo.html")
    HtmlResource prettify();

    @Source("ReverseFilterDemo.html")
    HtmlResource reverseFilter();

    @Source("TextInputDemo.html")
    HtmlResource textInput();

    @Source("UrlHashParameterDemo.html")
    HtmlResource urlHashParameter();

    TextInput textInputResources();

    interface TextInput extends ClientBundle {
        
        @Source("TextInputDemo.html")
        TextResource view();
        
        @Source("controller/TextInputDemoController.java")
        TextResource controller();
        
        @DoNotEmbed
        @MimeType("text/html")
        @Source("TextInputDemo.html")
        DataResource partial();
    }

    HttpClient httpClientResources();
    
    interface HttpClient extends ClientBundle {

        @Source("HttpClientDemo.html")
        TextResource view();
        
        @Source("controller/HttpClientDemoController.java")
        TextResource controller();
    }

    OnClickEvent onClickEventResources();
    
    interface OnClickEvent extends ClientBundle {

        @Source("OnClickEventDemo.html")
        TextResource view();
        
        @Source("controller/OnClickEventDemoController.java")
        TextResource controller();
    }

    
    ReverseFilter reverseFilterResources();
    
    interface ReverseFilter extends ClientBundle {

        @Source("ReverseFilterDemo.html")
        TextResource view();
        
        @Source("controller/ReverseFilterDemoController.java")
        TextResource controller();

        @Source("filter/Reverse.java")
        TextResource filter();

        @Source("ReverseFilterModule.txt")
        TextResource module();
    }
    
    UrlHashParameter urlHashParameterResources();

    interface UrlHashParameter extends ClientBundle {

        @Source("UrlHashParameterDemo.html")
        TextResource view();
        
        @Source("controller/UrlHashParameterDemoController.java")
        TextResource controller();
    }
    
    Prettify prettifyResources();

    interface Prettify extends ClientBundle {

        @Source("PrettifyDemo.html")
        TextResource view();
        
        @Source("controller/PrettifyDemoController.java")
        TextResource controller();
    }
    
    CustomDirectiveExampleResources customDirectiveResources();

    interface CustomDirectiveExampleResources extends ClientBundle {

        @Source("CustomDirectiveDemo.html")
        TextResource view();

        @Source("CustomeDirectiveModule.txt")
        TextResource module();
        
        @Source("directive/MyHello.java")
        TextResource directive();
        
        @Source("directive/MyHello.html")
        TextResource template();

        @Source("controller/CustomDirectiveDemoController.java")
        TextResource controller();
    }
}
