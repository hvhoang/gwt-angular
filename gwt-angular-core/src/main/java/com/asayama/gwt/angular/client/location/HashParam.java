package com.asayama.gwt.angular.client.location;

import com.asayama.gwt.jsni.client.JSObject;

public class HashParam extends KeyValuePair<String,String> {

	public HashParam(String key, String value) {
		super(key, value);
	}

}

class JSHashParam extends JSObject {

	protected JSHashParam() {
	}

	final void put(String key, String value ) {
		$string(key, value);
	}
}

class KeyValuePair<K,V> {

    private final K key;
    private final V value;
    
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K key() {
        return key;
    }
    
    public V value() {
        return value;
    }
}
