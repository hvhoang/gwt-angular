package com.asayama.gwt.angular.client.location;

import java.util.List;

import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;


public class Location implements Service {

	@Injector.Inject
    private NGLocation ngo;

    public String getHash() {
        return ngo.hash();
    }

    public Location setHash(String hash) {
        ngo.hash(hash);
        return this;
    }

    public Location setHashParam(String key, String value) {
        ngo.search(key, value);
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
        ngo.search(jso);
        return this;
    }
}

@Injector.Bind("$location")
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
