package com.asayama.gwt.util.client;

public class Arrays {

    public static <R> R[] shift(R[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            throw new IndexOutOfBoundsException("Cannot shift 0 length array");
        }
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        return array;
    }
}
