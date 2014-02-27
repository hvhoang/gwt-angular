package com.asayama.gwt.core.client.exceptions;


public class InvalidPathException extends RuntimeException {

    private static final long serialVersionUID = 9090641822227524381L;

    public InvalidPathException(String path) {
        super("Invalid path \"" + path + "\"");
    }
}
