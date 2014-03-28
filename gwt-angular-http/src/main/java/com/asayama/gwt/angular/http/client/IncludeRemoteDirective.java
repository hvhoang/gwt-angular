package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.Directive;
import com.asayama.gwt.angular.client.Template;


public class IncludeRemoteDirective implements Directive {

    @Override
    public Template getTemplate() {
        return Template.create("hello");
    }

}
