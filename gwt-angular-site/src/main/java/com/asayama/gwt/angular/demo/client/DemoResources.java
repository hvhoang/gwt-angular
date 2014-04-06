package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
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

    @Source("UrlHashParameterDemo.html")
    HtmlResource urlHashParameter();


    
    
    HttpClientResources httpClientResources();
    
    interface HttpClientResources extends ClientBundle {

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

    
    CustomFilterResources customFilterResources();
    
    interface CustomFilterResources extends ClientBundle {

        @Source("ReverseFilterDemo.html")
        TextResource view();
        
        @Source("controller/ReverseFilterDemoController.java")
        TextResource controller();

        @Source("filter/Reverse.java")
        TextResource filter();

        @Source("ReverseFilterModule.txt")
        TextResource module();
    }
    
    UrlHashParameterResources urlHashParameterResources();

    interface UrlHashParameterResources extends ClientBundle {

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
