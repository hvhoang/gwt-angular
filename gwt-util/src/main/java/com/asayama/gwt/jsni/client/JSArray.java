package com.asayama.gwt.jsni.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * https://github.com/kyoken74/gwt-angular/issues/28
 * 
 * @author kyoken74
 *
 * @param <T> Element type of the list
 */
public class JSArray<T> extends JavaScriptObject {
    
    public static final String[] STRING_ARRAY = new String[0];
    public static final Boolean[] BOOLEAN_ARRAY = new Boolean[0];
    public static final Integer[] INTEGER_ARRAY = new Integer[0];
    public static final Long[] LONG_ARRAY = new Long[0];
    public static final Double[] DOUBLE_ARRAY = new Double[0];
    public static final Date[] DATE_ARRAY = new Date[0];

    public static native <T> JSArray<T> create() /*-{
        return [];
    }-*/;

    public static native <T> JSArray<T> eval(String expr) /*-{
        return eval('('+expr+')');
    }-*/;

    public static  <T> JSArray<T> create(T[] objects) {
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
    
    public final native int unshift(T e) /*-{
        return this.unshift(e);
    }-*/;
    
    public final native boolean add(T e) /*-{
        this.push(e);
        return true;
    }-*/;
    
    public final native void add(int index, T element) /*-{
        this.splice(index, 0, element);
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

    public final boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> it = c.iterator();
        boolean isChanged = false;
        while (it.hasNext()) {
            isChanged = isChanged || add(it.next());
        }
        return isChanged;
    }

    public final boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    public final void clear() {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public final boolean contains(Object o) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T e = it.next();
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    public final int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Iterator<T> iterator() {
        return new Iterator<T>() {
            
            int pos = -1;
            
            @Override
            public boolean hasNext() {
                return pos + 1 < size();
            }

            @Override
            public T next() {
                pos++;
                if (pos >= size()) {
                    throw new IndexOutOfBoundsException("index=" + pos + ", size=" + size());
                }
                T item = get(pos);
                return item;
            }

            @Override
            public void remove() {
                JSArray.this.remove(pos);
                pos--;
            }
        };
    }

    public final int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public final ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public final ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    public final boolean remove(Object o) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T e = it.next();
            if (e.equals(o)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public final T remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size());
        }
        T result = get(index);
        _remove(index);
        return result;
    }
    
    private final native void _remove(int index) /*-{
        this.splice(index, 1);
    }-*/;

    public final boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    public final boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    public final T set(int index, T element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size());
        }
        T result = get(index);
        _set(index, element);
        return result;
    }
    
    private final native void _set(int index, T element) /*-{
        this[index] = element;
    }-*/;

    public final List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

}
