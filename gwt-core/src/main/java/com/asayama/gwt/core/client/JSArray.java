package com.asayama.gwt.core.client;

import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptObject;


public class JSArray<T> extends JavaScriptObject {
    
    public static final String[] STRING = new String[0];

	public static native <T> JSArray<T> create() /*-{
		return [];
	}-*/;

	public static  <T> JSArray<T> create(T... objects) {
		JSArray<T> array = null;
		if (objects != null) {
			array = create();
			for (T object : objects) {
				array.add(object);
			}
		}
		return array;
	}

	protected JSArray() {
	}
	
	public final T get(int i) {
		if (i < 0 || size() < i) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return _get(i);
	}

	public final native T _get(int i) /*-{
		return this[i];
	}-*/;
	
	public final native boolean add(T object) /*-{
		this.push(object);
		return true;
	}-*/;

	public final native void add(int index, T object) /*-{
		this.splice(index, 0, object);
	}-*/;
	
	public final native int size() /*-{
		return this.length;
	}-*/;

	public final Object[] toArray() {
	    Object[] array = new Object[size()];
	    for (int i = 0; i < size(); i++) {
	        array[i] = get(i);
	    }
	    return array;
	}

	public final <U extends Object> U[] toArray(U[] a) {
	    ArrayList<T> list = new ArrayList<T>();
	    for (int i = 0; i < size(); i++) {
	        list.add(get(i));
	    }
	    return list.toArray(a);
	}

}
