package com.asayama.gwt.angular.rebind;

import com.google.gwt.core.ext.typeinfo.JField;


public class Field {

    private final JField field;
    private final String className;
    private final String dependency;
    private final String name;
    
    public Field(JField field, String className, String dependency, String name) {
        this.field = field;
        this.className = className;
        this.dependency = dependency;
        this.name = name;
    }
    
    public JField getField() {
        return field;
    }
    
    public String getClassName() {
        return className;
    }
    
    public String getDependency() {
        return dependency;
    }
    
    public String getName() {
        return name;
    }
}
