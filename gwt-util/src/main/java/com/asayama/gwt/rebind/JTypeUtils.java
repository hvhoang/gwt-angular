package com.asayama.gwt.rebind;

import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JType;

public class JTypeUtils {

    public static boolean isVoid(JType type) {
        JPrimitiveType primitiveType = type.isPrimitive();
        return primitiveType != null && primitiveType.equals(JPrimitiveType.VOID);
    }

}
