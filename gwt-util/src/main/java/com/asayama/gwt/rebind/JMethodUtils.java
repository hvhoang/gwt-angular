package com.asayama.gwt.rebind;

import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;

public class JMethodUtils {

    public static boolean returnsVoid(JMethod method) {
        return JTypeUtils.isVoid(method.getReturnType());
    }
    
    public static String getArgs(JMethod method) {
        StringBuilder sb = new StringBuilder();
        JParameter[] params = method.getParameters();
        for (int i = 0; i < params.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(params[i].getName());
        }
        return sb.toString();
    }

    public static boolean isGetter(JMethod method) {
        return method.getName().startsWith("get")
                && method.getName().length() > 3
                && !JTypeUtils.isVoid(method.getReturnType())
                && method.getParameters().length == 0;
    }
    
    public static boolean isSetter(JMethod method) {
        return method.getName().startsWith("set")
                && method.getName().length() > 3
                && method.getParameters().length == 1;
    }
    
    public static String getProp(JMethod method) {
        if (isGetter(method) || isSetter(method)) {
            String p = method.getName().substring(3);
            char c = p.charAt(0);
            c = Character.toLowerCase(c);
            return new Character(c) + p.substring(1);
        }
        return null;
    }

}
