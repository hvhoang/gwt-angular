package com.asayama.gwt.angular.client.location;

import java.util.List;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Location implements Service, NGObjectWrapper {
	
	NGLocation ngo;
	
	public String getHash() {
		return getNGObject().hash();
	}
	
	public Location setHash(String hash) {
		getNGObject().hash(hash);
		return this;
	}
	
	public Location setHashParam(String key, String value) {
		getNGObject().search(key, value);
		return this;
	}
	
	public Location setHashParam(List<HashParam> params) {
		if (params == null || params.size() == 0) {
			return this;
		}
		JSHashParam jso = JSHashParam.create();
		for (HashParam p : params) {
			jso.put(p.key(), p.value());
		}
		getNGObject().search(jso);
		return this;
	}
	
	@Override
	public void wrap(NGObject ngo) {
		this.ngo = NGObject.cast(ngo);
	}
	NGLocation getNGObject() {
		return ngo;
	}

}
@Bind("$location")
class NGLocation extends NGObject {

	protected NGLocation() {
	}

	final native String hash() /*-{
		return this.hash();
	}-*/;
	
	final native void hash(String hash) /*-{
		this.hash(hash);
	}-*/;
	
	final native void search(String key, String value) /*-{
		this.search(key, value);
	}-*/;
	
	final native void search(JSHashParam param) /*-{
		this.search(param);
	}-*/;

}
