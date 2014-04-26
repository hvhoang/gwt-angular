package com.asayama.gwt.rebind.exceptions;



public class RebindException extends RuntimeException {

    private static final long serialVersionUID = 7474984536348014799L;

    public RebindException(String message) {
        super(message);
    }
    
    public RebindException(String message, Throwable cause) {
        super(message, cause);
    }

    public RebindException(Throwable cause) {
        super(cause);
    }

}
