package com.asayama.gwt.angular.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Promise.Continue;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.user.client.Timer;

public class PromiseDemoController implements Controller {

    private Q q;
    
    private String greeting = "Click " + getButtonCaption();
    private String buttonCaption = "Go";
    
    @Override
    public void onControllerLoad() {
    }
    
    public void onClickGo() {
        promiseGreeting().then(
                new Continue<String, JSArray<?>>() {
                    public String call(JSArray<?> value) {
                        return value.get(0) + ", " + value.get(1) + "!";
                    }
                }).then(new Done<String>() {
                    public void call(String value) {
                        setGreeting(value);
                        setButtonCaption("Go Again");
                    }
                });
    }
    
    public Promise<JSArray<?>> promiseGreeting() {
        setGreeting("Please wait 1 second...");
        return q.all(promiseSalutation(), promiseName());
    }
    
    public Promise<String> promiseName() {
        final Deferred<String> d = q.defer();
        new Timer() {
            public void run() {
                d.resolve("World");
            }
        }.schedule(1000);
        return d.promise();
    }
    
    public Promise<String> promiseSalutation() {
        final Deferred<String> d = q.defer();
        new Timer() {
            public void run() {
                d.resolve("Hello");
            }
        }.schedule(1000);
        return d.promise();
    }

    // Getters and Setters
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    public String getButtonCaption() {
        return buttonCaption;
    }
    
    public void setButtonCaption(String buttonCaption) {
        this.buttonCaption = buttonCaption;
    }
}
