package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.q.Progress;
import com.google.gwt.http.client.Request;


public class HttpClientProgress extends Progress {

    private final Request request;
    
    public HttpClientProgress(String message, Request request) {
        super(message);
        this.request = request;
    }
    
    @Override
    public void cancel() {
        request.cancel();
    }
}
