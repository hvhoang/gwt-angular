package com.asayama.gwt.core.client.util;

import java.util.List;


public class Arrays {

    public static <R> R[] shift(R[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            throw new IndexOutOfBoundsException("Cannot shift 0 length array");
        }
        List<R> list = java.util.Arrays.asList(array);
        list.remove(0);
        return list.toArray(array);
    }
}
