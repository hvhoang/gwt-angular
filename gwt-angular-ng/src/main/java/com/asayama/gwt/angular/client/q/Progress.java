package com.asayama.gwt.angular.client.q;


public abstract class Progress {

    private final String message;

    public Progress(String message) {
        this.message = message;
    }
    
    public abstract void cancel();
    
    public String getMessage() {
        return this.message;
    }
}
