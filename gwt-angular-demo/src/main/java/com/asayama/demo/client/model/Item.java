package com.asayama.demo.client.model;

import com.asayama.gwt.core.client.JSObject;

public class Item extends JSObject {

	protected Item() {
	}

	public final String getId() {
		return getString("id");
	}
	
	public final Item setId(String id) {
		putString("id", id);
		return this;
	}
	
	public final String getDisplayName() {
		return getString("displayName");
	}
	
	public final Item setDisplayName(String displayName) {
		putString("displayName", displayName);
		return this;
	}

	public final String getProperty(String key) {
		return getString(key);
	}
	
	public final Item putProperty(String key, String value) {
		putString(key, value);
		return this;
	}

}
