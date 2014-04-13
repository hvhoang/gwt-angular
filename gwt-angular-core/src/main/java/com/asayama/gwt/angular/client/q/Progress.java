package com.asayama.gwt.angular.client.q;


public class Progress<H> {

    private final String message;
    private final H handle;

    public Progress(H handle) {
        this(handle, "");
    }
    
    public Progress(H handle, String message) {
        this.handle = handle;
        this.message = message;
    }
    
    public H getHandle() {
        return handle;
    }
    
    public String getMessage() {
        return this.message;
    }
}
