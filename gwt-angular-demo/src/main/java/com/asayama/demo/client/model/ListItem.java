package com.asayama.demo.client.model;

import com.asayama.gwt.core.client.JSObject;

public class ListItem extends JSObject {

	public static ListItem create() {
		return JSObject.<ListItem>create();
	}
	
	protected ListItem() {
	}
	
	public final String getCaption() {
		return getString("caption");
	}
	
	public final ListItem setCaption(String caption) {
		putString("caption", caption);
		return this;
	}

	public final String getRoute() {
		return getString("route");
	}
	
	public final ListItem setRoute(String route) {
		putString("route", route);
		return this;
	}

}
