package com.asayama.gwt.angular.client;

import com.google.gwt.resources.client.TextResource;


public class TemplateDirective extends AbstractDirective {

    private final String template;
    
    public TemplateDirective(TextResource templateText) {
        this.template = templateText.getText();
    }
    
    @Override
    public Template template() {
        return Template.create(template);
    }
    
}
