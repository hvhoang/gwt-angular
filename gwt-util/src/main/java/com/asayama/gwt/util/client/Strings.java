package com.asayama.gwt.util.client;

public class Strings {

    public static String trim(String string) {
        return string == null ? null : string.trim();
    }
    
    public static String concat(String... strings) {
        if (strings == null) {
            return null;
        }
        String j = "";
        for (String s : strings) {
            j += s;
        }
        return j;
    }

    public static String decapitalize(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        Character cap = string.charAt(0);
        String rest = "";
        if (string.length() > 1) {
            rest = string.substring(1);
        }
        return cap.toString().toLowerCase() + rest;
    }
    
    public static String simpleName(Class<?> klass) {
        if (klass == null) {
            return null;
        }
        String[] split = klass.getName().split("\\.");
        return split[split.length - 1];
    }
}
