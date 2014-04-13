package com.asayama.gwt.angular.demo.client.service;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Progress;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Promise.Continue;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.user.client.Timer;

public class GreetingService implements Service {

    // Q service is injected by Angular
    private Q q;
    
    // Given the promises of name and salutation, returns a promise of greeting.
    public Promise<String> getGreeting() {
        Promise<String> p = q.all(getSalutation(), getName())
            .then(new Continue<String, JSArray<?>>() {
                
                // Formats the greeting when salutation and name are delivered.
                @Override
                public String call(JSArray<?> value) {
                    return value.get(0) + ", " + value.get(1) + "!";
                }
            });
        return p;
    }
    
    // Returns a promise of salutation by simulating an asynchronous call with a time-out.
    public Promise<String> getSalutation() {
        final Deferred<String,Timer> d = q.defer();
        Timer timer = new Timer() {
            
            @Override
            public void run() {
                d.progress(new Progress<Timer>(this, "Loaded salutation"));
                d.resolve("Hello");
            }
        };
        d.progress(new Progress<Timer>(timer, "Loading salutation..."));
        timer.schedule(1000);
        return d.promise();
    }

    // Returns a promise of name by simulating an asynchronous call with a time-out.
    public Promise<String> getName() {
        final Deferred<String,Timer> d = q.defer();
        Timer timer = new Timer() {

            @Override
            public void run() {
                d.progress(new Progress<Timer>(this, "Loaded name"));
                d.resolve("World");
            }
        };
        d.progress(new Progress<Timer>(timer, "Loading name..."));
        timer.schedule(500);
        return d.promise();
    }
}
