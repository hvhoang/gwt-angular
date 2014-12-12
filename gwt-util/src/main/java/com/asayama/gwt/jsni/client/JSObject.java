package com.asayama.gwt.jsni.client;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.jsni.client.exceptions.EmptyKeyException;
import com.asayama.gwt.jsni.client.exceptions.UndefinedException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

/**
 * Represents a JavaScriptObject, and used as a syntax sugar, i.e. a shorthand
 * for its direct parent.
 * 
 * @author kyoken74
 * @see Function
 * @see Invoker
 */
public class JSObject extends JavaScriptObject {
    
    private static final String CLASS = JSObject.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    public static final JavaScriptObject $wnd = $wnd();
    public static final JavaScriptObject $doc = $doc();
    
    private static final native JavaScriptObject $wnd() /*-{
        return $wnd;
    }-*/;
    
    private static final native JavaScriptObject $doc() /*-{
        return $doc;
    }-*/;
    
    public static native <T extends JSObject> T create() /*-{
        return {};
    }-*/;
    
    public static native <T extends JSObject> T eval(String expr) /*-{
        return eval('('+expr+')');
    }-*/;

    protected JSObject() {
    }

    public final String toJavaScript() {
        try {
            return new JSONObject(this).toString();
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Unable to obtain the script", e);
            return this.toString();
        }
    }

    private final native boolean _isThisUndefined() /*-{
        return (typeof(this) == "undefined");
    }-*/;

    protected final void _checkUndefined() throws UndefinedException {
        if (_isThisUndefined()) {
            throw new UndefinedException();
        }
    }

    private final void _checkEmptyKey(String key) throws EmptyKeyException {
        if (key == null || key.length() == 0) {
            throw new EmptyKeyException();
        }
    }

    private final native boolean _isPropUndefined(String key) /*-{
        return (typeof(this[key]) == "undefined");
    }-*/;
    
    private final native boolean _isPropNull(String key) /*-{
        return (this[key] == null);
    }-*/;
    
    /*
     * Object
     */

    @SuppressWarnings("unchecked")
    protected final <T> T $object(String key) throws ClassCastException, UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        if (_isPropUndefined(key) || _isPropNull(key)) {
            return null;
        }
        return (T) _object(key);
    }
    
    private final native Object _object(String key) /*-{
        return this[key];
    }-*/;
    
    protected final <T> void $object(String key, T value) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        _object(key, value);
    }

    private final native void _object(String key, Object value) /*-{
        this[key] = value;
    }-*/;
    
    /*
     * JSObject
     */

    protected final <T extends JSObject> T $jsobject(String key) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        if (_isPropUndefined(key) || _isPropNull(key)) {
            return null;
        }
        return _jsobject(key).cast();
    }

    private final native JSObject _jsobject(String key) /*-{
        return this[key];
    }-*/;

    protected final <T extends JSObject> void $jsobject(String key, T value)
            throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        value._checkUndefined();
        _jsobject(key, value);
    }

    private final native void _jsobject(String key, JSObject value) /*-{
        this[key] = value;
    }-*/;
    
    /*
     * Array
     */
    protected final <T> JSArray<T> $jsarray(String key) throws UndefinedException, EmptyKeyException {
        JSObject value = $jsobject(key);
        return value == null ? null : value.<JSArray<T>>cast();
    }

    protected final <T> void $jsarray(String key, JSArray<T> value) throws UndefinedException, EmptyKeyException {
        $jsobject(key, value == null ? null : value.<JSObject>cast());
    }

    /*
     * String
     */

    protected final String $string(String key) throws UndefinedException,
            EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        if (_isPropUndefined(key) || _isPropNull(key)) {
            return null;
        }
        return _string(key);
    }

    private final native String _string(String key) /*-{
        return this[key];
    }-*/;

    protected final void $string(String key, String value) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        _string(key, value);
    }

    private final native void _string(String key, String value) /*-{
        this[key] = value;
    }-*/;

    /*
     * Integer
     */

    protected final Integer $integer(String key) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        if (_isPropUndefined(key) || _isPropNull(key)) {
            return null;
        }
        return _integer(key);
    }

    private final native int _integer(String key) /*-{
        return Number(this[key]);
    }-*/;

    protected final void $integer(String key, Integer value) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        _integer(key, value);
    }
    
    private final native void _integer(String key, Integer value) /*-{
        this[key] = value;
    }-*/;

    /*
     * Double
     */
    
    protected final Double $double(String key) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        if (_isPropUndefined(key) || _isPropNull(key)) {
            return null;
        }
        return _double(key);
    }
    
    private final native double _double(String key) /*-{
        return Number(this[key]);
    }-*/;

    protected final void $double(String key, Double value) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        _double(key, value);
    }
    
    private final native void _double(String key, Double value) /*-{
        this[key] = value;
    }-*/;

    /*
     * Boolean
     */
    
    protected final Boolean $boolean(String key) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        if (_isPropUndefined(key) || _isPropNull(key)) {
            return null;
        }
        return _boolean(key);
    }

    private final native boolean _boolean(String key) /*-{
        return this[key];
    }-*/;
    
    protected final void $boolean(String key, Boolean value) throws UndefinedException, EmptyKeyException {
        _checkUndefined();
        _checkEmptyKey(key);
        _boolean(key, value);
    }
    
    private final native void _boolean(String key, Boolean value) /*-{
        this[key] = value;
    }-*/;

    /*
     * Long
     */
    
    protected final Long $long(String key) throws UndefinedException, EmptyKeyException {
        String value = $string(key);
        return value == null ? null : Long.valueOf(value);
    }

    protected final void $long(String key, Long value) throws UndefinedException, EmptyKeyException {
        $string(key, value+"");
    }

    /*
     * Date
     */
    
    protected final Date $date(String key) throws UndefinedException, EmptyKeyException {
        Long value = $long(key);
        return value == null ? null : new Date(value);
    }

    protected final void $date(String key, Date value) throws UndefinedException, EmptyKeyException {
        $long(key, value.getTime());
    }
    
}
