package com.asayama.gwt.jsni.client;

import java.util.Date;

import com.asayama.gwt.jsni.client.exceptions.InvalidPathException;


public class JSONPath {

    public static <T> T getObject(JSON json, String path) {
        return get(json, path, new Function<T>() {
            @Override
            public T call(Object... args) {
                return ((JSON) args[0]).getObject((String) args[1]);
            }
        });
    }
    
    public static <T extends JSON> T getJSON(JSON json, String path) {
        return get(json, path, new Function<T>() {
            @Override
            public T call(Object... args) {
                return ((JSON) args[0]).getJSON((String) args[1]);
            }
        });
    }
    
    public static <T extends JSObject> T getJSObject(JSON json, String path) {
        return get(json, path, new Function<T>() {
            @Override
            public T call(Object... args) {
                return ((JSON) args[0]).getJSObject((String) args[1]);
            }
        });
    }
    
    public static <T> JSArray<T> getJSArray(JSON json, String path) {
        return get(json, path, new Function<JSArray<T>>() {
            @Override
            public JSArray<T> call(Object... args) {
                return ((JSON) args[0]).getJSArray((String) args[1]);
            }
        });
    }
    
    public static <T> JSFunction<T> getJSFunction(JSON json, String path) {
        return get(json, path, new Function<JSFunction<T>>() {
            @Override
            public JSFunction<T> call(Object... args) {
                return ((JSON) args[0]).getJSFunction((String) args[1]);
            }
        });
    }
    
    public static JSClosure getJSClosure(JSON json, String path) {
        return get(json, path, new Function<JSClosure>() {
            @Override
            public JSClosure call(Object... args) {
                return ((JSON) args[0]).getJSClosure((String) args[1]);
            }
        });
    }
    
    public static String getString(JSON json, String path) {
        return get(json, path, new Function<String>() {
            @Override
            public String call(Object... args) {
                return ((JSON) args[0]).getString((String) args[1]);
            }
        });
    }
    
    public static Integer getInteger(JSON json, String path) {
        return get(json, path, new Function<Integer>() {
            @Override
            public Integer call(Object... args) {
                return ((JSON) args[0]).getInteger((String) args[1]);
            }
        });
    }
    
    public static Double getDouble(JSON json, String path) {
        return get(json, path, new Function<Double>() {
            @Override
            public Double call(Object... args) {
                return ((JSON) args[0]).getDouble((String) args[1]);
            }
        });
    }
    
    public static Boolean getBoolean(JSON json, String path) {
        return get(json, path, new Function<Boolean>() {
            @Override
            public Boolean call(Object... args) {
                return ((JSON) args[0]).getBoolean((String) args[1]);
            }
        });
    }
    
    public static Long getLong(JSON json, String path) {
        return get(json, path, new Function<Long>() {
            @Override
            public Long call(Object... args) {
                return ((JSON) args[0]).getLong((String) args[1]);
            }
        });
    }
    
    public static Date getDate(JSON json, String path) {
        return get(json, path, new Function<Date>() {
            @Override
            public Date call(Object... args) {
                return ((JSON) args[0]).getDate((String) args[1]);
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
            if (i == 0 && (s == null || s.length() == 0)) {
                continue; //first slash is ignored, if it exists
            }
            if (s.contains("[") && s.contains("]")) {
                String key = s.substring(0, s.indexOf("["));
                String indexString = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                if (indexString == null || indexString.length() == 0) {
                    throw new InvalidPathException(path);
                }
                JSArray<JSON> array = node.getJSArray(key);
                if (array == null) {
                    throw new InvalidPathException(path);
                }
                int index = Integer.valueOf(indexString);
                int size = array.size();
                if (index >= size) {
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
                    return getter.call(node, key);
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
