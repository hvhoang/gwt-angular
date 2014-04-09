package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSObject;


public class Promise<V> extends JSObject {
    
    protected Promise() {
    }

    public static interface Done<V> {
        void call(V value);
    }

    public static interface Success<X, V> {
        X call(V value);
    }

    public static interface Error<X, V> {
        X call(V value);
    }

    public static interface Notify<X, V> {
        X call(V value);
    }

    public final <X> Promise<X> then(Success<X, V> success) {
        return then(success, null, null);
    }

    public final <X> Promise<X> then(Error<X, V> error) {
        return then(null, error, null);
    }
    
    public final <X> Promise<X> then(Notify<X, V> notify) {
        return then(null, null, notify);
    }
    
    public final Promise<V> then(final Done<V> success) {
        then(new Success<Object, V>() {
            @Override
            public Object call(V value) {
                success.call(value);
                return null;
            }
        }, null, null);
        return this;
    }

    public final <X> Promise<X> then(final Success<X, V> success, final Error<X, V> error, final Notify<X, V> notify) {
        Promise<X> p = _then(
                success == null ? null : JSFunction.create(new Function<Object>() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public Object call(Object... args) {
                        if (args == null || args.length == 0) {
                            return success.call(null);
                        }
                        return success.call((V) args[0]);
                    }
                }),
                error == null ? null : JSFunction.create(new Function<Object>() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public Object call(Object... args) {
                        if (args == null || args.length == 0) {
                            return error.call(null);
                        }
                        return error.call((V) args[0]);
                    }
                }),
                notify == null ? null : JSFunction.create(new Function<Object>() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public Object call(Object... args) {
                        if (args == null || args.length == 0) {
                            return notify.call(null);
                        }
                        return notify.call((V) args[0]);
                    }
                }));
        return p;
    }

    private final native <X> Promise<X> _then(JSFunction<?> success, JSFunction<?> error, JSFunction<?> notify) /*-{
        return this.then(success, error, notify);
    }-*/;
}
