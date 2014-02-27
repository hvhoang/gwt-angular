package com.asayama.gwt.core.client;

import java.util.Date;


public class JSON extends JSObject {

    protected JSON() {
    }
    
    public final <T> T getObject(String key) {
        return $object(key);
    }

    public final <T> void put(String key, T value) {
        $object(key, value);
    }
    
    public final JSON getJSON(String key) {
        return $jso(key);
    }

    public final void put(String key, JSON value) {
        $jso(key, value);
    }
    
    public final <T> JSArray<T> getArray(String key) {
        return $array(key);
    }
    
    public final <T> void put(String key, JSArray<T> value) {
        $array(key, value);
    }
    
    public final String getString(String key) {
        return $string(key);
    }
    
    public final void put(String key, String value) {
        $string(key, value);
    }
    
    public final Integer getInteger(String key) {
        return $integer(key);
    }
    
    public final void put(String key, Integer value) {
        $integer(key, value);
    }

    public final Double getDouble(String key) {
        return $double(key);
    }

    public final void put(String key, Double value) {
        $double(key, value);
    }
    
    public final Boolean getBoolean(String key) {
        return $boolean(key);
    }
    
    public final void put(String key, Boolean value) {
        $boolean(key, value);
    }
    
    public final Long getLong(String key) {
        return $long(key);
    }
    
    public final void put(String key, Long value) {
        $long(key, value);
    }
    
    public final Date getDate(String key) {
        return $date(key);
    }
    
    public final void put(String key, Date value) {
        $date(key, value);
    }

}
