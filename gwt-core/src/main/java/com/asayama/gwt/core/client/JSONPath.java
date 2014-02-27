package com.asayama.gwt.core.client;

import com.asayama.gwt.core.client.exceptions.InvalidPathException;


public class JSONPath {

    public static String getString(JSON json, String path) {
        return get(json, path, new Function<String>() {
            @Override
            public String function(Object... args) {
                return ((JSON) args[0]).getString((String) args[1]);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    private static <R> R get(JSON json, String path, Function<R> getter) {
        String[] split = path == null ? null : path.split("/");
        if (split == null || split.length == 0) {
            throw new InvalidPathException(path);
        }
        JSON node = json;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.contains("[") && s.contains("]")) {
                String key = s.substring(0, s.indexOf("["));
                String indexString = s.substring(s.indexOf("["), s.indexOf("]"));
                if (indexString == null || indexString.length() == 0) {
                    throw new InvalidPathException(path);
                }
                JSArray<JSON> array = node.getArray(key);
                if (array == null) {
                    throw new InvalidPathException(path);
                }
                int index = Integer.valueOf(indexString);
                int size = array.size();
                if (index > size) {
                    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                }
                if (i == split.length - 1) {
                    return (R) array.get(index);
                } else {
                    node = array.get(index);
                    if (node == null) {
                        return null;
                    }
                }
            } else {
                String key = s;
                if (i == split.length - 1) {
                    return getter.function(node, key);
                } else {
                    node = node.getJSON(key);
                    if (node == null) {
                        return null;
                    }
                }
            }
        }
        throw new InvalidPathException(path);
    }

}
