package com.asayama.gwt.angular.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

public class HttpClientExampleController implements Controller {

    // Fields of type Injectable are injected by the framework
    
    private HttpClient http;

    // Other fields are used to represent the state of this controller

    private JSArray<Mayor> mayors;

    @Override
    public void onControllerLoad() {
        String url = "HttpClientExample.json";
        HttpClientCallback callback = new HttpClientCallback() {
            @Override
            public void onSuccess(Request request, Response response) {
                JSArray<Mayor> mayors = JSArray.eval(response.getText());
                setMayors(mayors);
            }

            @Override
            public void onError(Request request, Exception exception) {
                GWT.log("onError", exception);
            }
        };
        http.get(url, callback);
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.

    public JSArray<Mayor> getMayors() {
        return mayors;
    }

    public void setMayors(JSArray<Mayor> mayors) {
        this.mayors = mayors;
    }
}

/**
 * Represents a model object.
 */
class Mayor extends JSON {

    protected Mayor() {
    }
    
    public final String getName() {
        return getString("name");
    }
    
    public final String getCity() {
        return getString("city");
    }
}
