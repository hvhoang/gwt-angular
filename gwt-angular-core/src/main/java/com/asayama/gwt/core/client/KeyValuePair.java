package com.asayama.gwt.core.client;

public class KeyValuePair<K,V> {

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
