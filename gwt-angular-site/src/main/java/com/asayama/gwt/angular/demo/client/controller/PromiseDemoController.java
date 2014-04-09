package com.asayama.gwt.angular.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.client.q.Promise.Success;
import com.google.gwt.user.client.Timer;

public class PromiseDemoController implements Controller {

    private Q q;
    
    @Override
    public void onControllerLoad() {


        final Deferred<String> d = q.defer();
        new Timer() {
            @Override
            public void run() {
                d.resolve("World");
            }
        }.schedule(1000);
        Promise<String> p = d.promise();
        
        p.then(new Success<String, String>() {
            @Override
            public String call(String value) {
                return "Hello, " + value + "!";
            }
        }).then(new Done<String>() {
            @Override
            public void exec(String value) {
                foo = value;
            }
        });
    }

    private String foo = "foo";
    
    public String getFoo() {
        return foo;
    }
}
