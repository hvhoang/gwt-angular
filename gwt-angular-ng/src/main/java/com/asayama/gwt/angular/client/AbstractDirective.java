package com.asayama.gwt.angular.client;

import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.util.client.Strings;
import com.google.gwt.resources.client.TextResource;

/**
 * Provides an abstract implementation of a custom directive.
 * 
 * @author kyoken74
 */
public abstract class AbstractDirective implements Directive {

    private String name = Strings.decapitalize(Strings.simpleName(getClass()));
    
    @Override
    public boolean getTransclude() {
        return false;
    }
    
    /**
     * Returns the name of the directive. It is typically the decapitalized 
     * simple class name. For example, a directive with class name
     * {@code com.asayama.directive.FooBar} would have the name 
     * "{@code fooBar}".
     * 
     * @see com.asayama.gwt.angular.client.AbstractModule#directive(Class)
     */
    @Override
    public final String getName() {
        return name;
    }
    
    /**
     * Assigns a name to the instance of the directive. This method is provided
     * so that the user can override the default behavior, which is to assign
     * the decapitalized simple class name of the directive class.
     */
    @Override
    public final void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Attribute };
    }

    @Override
    public TextResource getTemplate() {
        return null;
    }

    @Override
    public String getTemplateUrl() {
        return null;
    }
    
    /**
     * User must override this method to create isolateScope.
     * <pre>
     * {@code @Override}
     * public NGScope scope() {
     *   NGScope isolateScope = NGScope.create();
     *   isolateScope.put(getName(), "=");
     *   return isolateScope;
     * }
     * </pre>
     */
    @Override
    public NGScope scope() {
        return null;
    }

    @Override
    public void compile(JQElement element, JSON attrs) {
        //noop by default
    }
    
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        // noop by default
    }
}
