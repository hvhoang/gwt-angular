package com.asayama.gwt.angular.client.location;

import com.asayama.gwt.core.client.JSObject;
import com.asayama.gwt.core.client.KeyValuePair;

public class HashParam extends KeyValuePair<String,String> {

	public HashParam(String key, String value) {
		super(key, value);
	}

}
class JSHashParam extends JSObject {

	protected JSHashParam() {
	}

	final void put(String key, String value ) {
		putString(key, value);
	}

}
