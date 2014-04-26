package com.asayama.gwt.angular.rebind.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gwt.core.ext.typeinfo.JClassType;


public class ClassTypeFields extends HashMap<JClassType, List<Field>> {

    private static final long serialVersionUID = -100685885797630018L;

    public Set<JClassType> getClassTypes() {
        return keySet();
    }
    
    public List<Field> getInjectables(JClassType classType) {
        List<Field> result = new ArrayList<Field>();
        Iterator<Field> it = get(classType).iterator();
        while (it.hasNext()) {
            Field field = it.next();
            if (field.getDependency() != null) {
                result.add(field);
            }
        }
        return result;
    }

    public List<Field> getPublicFinalProperties(JClassType classType) {
        List<Field> result = new ArrayList<Field>();
        Iterator<Field> it = get(classType).iterator();
        while (it.hasNext()) {
            Field field = it.next();
            if (field.getField().isPublic() && field.getField().isFinal()) {
                result.add(field);
            }
        }
        return result;
    }
}
