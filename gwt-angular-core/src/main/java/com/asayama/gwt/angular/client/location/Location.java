package com.asayama.gwt.angular.client.location;

import java.util.List;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Location implements Service, NGObjectWrapper<LocationJSO> {
	
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
	
	public Location setHashParam(List<HashParam> params) {
		if (params == null || params.size() == 0) {
			return this;
		}
		HashParamJSO jso = HashParamJSO.create();
		for (HashParam p : params) {
			jso.put(p.key(), p.value());
		}
		delegate.search(jso);
		return this;
	}
	
	@Override
	public void wrap(LocationJSO ngo) {
		this.delegate = NGObject.cast(ngo);
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
	
	final native void search(HashParamJSO param) /*-{
		this.search(param);
	}-*/;

}
