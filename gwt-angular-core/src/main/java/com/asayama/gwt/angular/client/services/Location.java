package com.asayama.gwt.angular.client.services;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;
import com.asayama.gwt.core.client.KeyValuePair;

public class Location implements Service, NGObjectWrapper {

	LocationJSO delegate;
	
	public String getHash() {
		return delegate.hash();
	}
	
	public Location setHash(String hash) {
		delegate.hash(hash);
		return this;
	}
	
	public Location setHashParam(String key, String value) {
		delegate.search(key, value);
		return this;
	}
	
	public Location setHashParam(KeyValuePair<String,String>... kvp) {
		if (kvp == null || kvp.length == 0) {
			return this;
		}
		if (kvp.length == 1) {
			setHashParam(kvp[0].key(), kvp[0].value());
			return this;
		}
		HashParam param = HashParam.create();
		for (KeyValuePair<String,String> item : kvp) {
			param.put(item.key(), item.value());
		}
		delegate.search(param);
		return this;
	}
	
	@Override
	public void wrap(NGObject delegate) {
		this.delegate = delegate == null ? null : delegate.<LocationJSO>cast();
	}

}
@Bind("$location")
class LocationJSO extends NGObject {

	protected LocationJSO() {
	}

	final native String hash() /*-{
		return this.hash();
	}-*/;
	
	final native void hash(String hash) /*-{
		this.hash(hasl);
	}-*/;
	
	final native void search(String key, String value) /*-{
		this.search(key, value);
	}-*/;
	
	final native void search(HashParam param) /*-{
		this.search(param);
	}-*/;

}
class HashParam extends JSObject {

	protected HashParam() {
	}

	final void put(String key, String value ) {
		putString(key, value);
	}

}