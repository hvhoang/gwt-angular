package com.asayama.gwt.jsni.client;

public class JSClosure extends JSFunction<Void> {

    public static JSClosure create(Closure closure) {
        return _create(new Invoker(closure)).<JSClosure> cast();
    }

    protected JSClosure() {
    }

}
