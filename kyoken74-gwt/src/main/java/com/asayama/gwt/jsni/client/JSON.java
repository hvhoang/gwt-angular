package com.asayama.gwt.jsni.client;

import java.util.Date;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.json.client.JSONObject;


public class JSON extends JSObject {

    public static <T extends JSON> T parse(String jsonString) {
        return JsonUtils.safeEval(jsonString).cast();
    }
    
    protected JSON() {
    }
    
    public final native JSArray<String> keys() /*-{
        return Object.keys(this);
    }-*/;

    public final <T> T getObject(String key) {
        return $object(key);
    }

    public final <T> JSON put(String key, T value) {
        $object(key, value);
        return this;
    }
    
    public final <T extends JSON> T getJSON(String key) {
        return $jsobject(key);
    }

    public final JSON put(String key, JSON value) {
        $jsobject(key, value);
        return this;
    }
    
    public final <T extends JSObject> T getJSObject(String key) {
        return $jsobject(key);
    }

    public final JSON put(String key, JSObject value) {
        $jsobject(key, value);
        return this;
    }
    
    public final <T> JSArray<T> getJSArray(String key) {
        return $jsarray(key);
    }
    
    public final <T> JSON put(String key, JSArray<T> value) {
        $jsarray(key, value);
        return this;
    }
    
    public final <R> JSFunction<R> getJSFunction(String key) {
        return $jsobject(key) == null ? null : $jsobject(key).<JSFunction<R>>cast();
    }

    public final <R> JSON put(String key, JSFunction<R> value) {
        $object(key, value);
        return this;
    }
    
    public final JSClosure getJSClosure(String key) {
        return $jsobject(key) == null ? null : $jsobject(key).<JSClosure>cast();
    }

    public final JSON put(String key, JSClosure value) {
        $object(key, value);
        return this;
    }
    
    public final String getString(String key) {
        return $string(key);
    }
    
    public final JSON put(String key, String value) {
        $string(key, value);
        return this;
    }
    
    public final Integer getInteger(String key) {
        return $integer(key);
    }
    
    public final JSON put(String key, Integer value) {
        $integer(key, value);
        return this;
    }

    public final Double getDouble(String key) {
        return $double(key);
    }

    public final JSON put(String key, Double value) {
        $double(key, value);
        return this;
    }
    
    public final Boolean getBoolean(String key) {
        return $boolean(key);
    }
    
    public final JSON put(String key, Boolean value) {
        $boolean(key, value);
        return this;
    }
    
    public final Long getLong(String key) {
        return $long(key);
    }
    
    public final JSON put(String key, Long value) {
        $long(key, value);
        return this;
    }
    
    public final Date getDate(String key) {
        return $date(key);
    }
    
    public final JSON put(String key, Date value) {
        $date(key, value);
        return this;
    }

    public final String toJSONString() {
        return new JSONObject(this).toString();
    }
}
