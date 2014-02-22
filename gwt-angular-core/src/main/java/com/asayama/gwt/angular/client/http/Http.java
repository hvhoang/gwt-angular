package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.JSClosure;

/**
 * <h1>This class does not work!</h1> I get the following error when unit
 * testing.
 * 
 * <pre>
 * Error: [$rootScope:inprog] $digest already in progress
 * http://errors.angularjs.org/1.2.9/$rootScope/inprog?p0=%24digest
 * </pre>
 * 
 * Consider using a GWT's RequestBuilder based API provided in
 * com.asayama.gwt.angular.http.AngularHttp.
 * 
 * @author kyoken74
 */
@Deprecated
public class Http implements Service {

    private NGHttp ngo;

    public void get(String url, final HttpCallback callback) {
        ngo.get(url, JSClosure.create(new Closure() {

            @Override
            public void closure(Object... args) {
                String data = (String) args[0];
                int status = (Integer) args[1];
                callback.onSuccess(status, data);
            }
        }), JSClosure.create(new Closure() {

            @Override
            public void closure(Object... args) {
                String data = (String) args[0];
                int status = (Integer) args[1];
                callback.onSuccess(status, data);
            }
        }));
    }
}

@Bind("$http")
class NGHttp extends NGObject {

    protected NGHttp() {
    }

    final native void get(String url, JSClosure successCallback,
            JSClosure errorCallback) /*-{
		this.get(url).success(successCallback).error(errorCallback);
	}-*/;
}
