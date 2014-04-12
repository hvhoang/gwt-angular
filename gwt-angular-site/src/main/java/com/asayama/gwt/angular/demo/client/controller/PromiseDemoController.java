package com.asayama.gwt.angular.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Progress;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Promise.Continue;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.client.q.Promise.Fail;
import com.asayama.gwt.angular.client.q.Promise.Notify;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.user.client.Timer;

public class PromiseDemoController implements Controller {

    // Q service is injected by Angular
    private Q q;
    
    // View Models
    private String buttonCaption = "Go";
    private String greeting = "Click " + getButtonCaption();
    
    @Override
    public void onControllerLoad() {
        // noop
    }
    
    public void onClickGo() {
        setGreeting("Loading...");
        promiseGreeting().then(new Done<String>() {
            // Refreshes the greeting model and update the button caption.
            @Override
            public void call(String value) {
                setGreeting(value);
                setButtonCaption("Go Again");
            }
        }).then(new Notify() {
            @Override
            public void call(Progress progress) {
                setGreeting(progress.getMessage());
            }
        }).then(new Fail() {
            @Override
            public void call(Throwable cause) {
                setGreeting(cause.getMessage());
            }
        });
    }
    
    // Given the promises of name and salutation, returns a promise of greeting.
    public Promise<String> promiseGreeting() {
        return q.all(promiseSalutation(), promiseName())
            .then(new Continue<String, JSArray<?>>() {
                // Formats the greeting when salutation and name are delivered.
                @Override
                public String call(JSArray<?> value) {
                    return value.get(0) + ", " + value.get(1) + "!";
                }
            });
    }
    
    // Returns a promise of name by simulating an asynchronous call with a time-out.
    public Promise<String> promiseName() {
        final Deferred<String> d = q.defer();
        d.progress(new Progress("Loading name..."));
        new Timer() {
            public void run() {
                d.progress(new Progress("Loaded name"));
                d.resolve("World");
            }
        }.schedule(500);
        return d.promise();
    }
    
    // Returns a promise of salutation by simulating an asynchronous call with a time-out.
    public Promise<String> promiseSalutation() {
        final Deferred<String> d = q.defer();
        d.progress(new Progress("Loading salutation..."));
        new Timer() {
            public void run() {
                d.progress(new Progress("Loaded salutation"));
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
