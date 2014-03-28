package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.Template;


public class IncludeRemoteDirective extends AbstractDirective {

    @Override
    public Template getTemplate() {
        return Template.create("hello");
    }

}
