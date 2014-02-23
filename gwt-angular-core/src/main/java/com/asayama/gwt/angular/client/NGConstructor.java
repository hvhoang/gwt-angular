package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * Represents the AngularJS constructor in the form of JavaScript array with
 * dependencies listed as strings + function. For example,
 * <pre>
 * var ctor = [ '$scope', '$http', function($scope, $http) {
 *   //initialize
 * } ];
 * </pre>
 * 
 * @author kyoken74
 */
class NGConstructor extends JsArrayMixed {

    static NGConstructor create(Closure initializer, String... dependencies) {
        return create(JSClosure.create(initializer), dependencies);
    }
    
    static NGConstructor create(JSClosure initializer, String... dependencies) {
        return create(dependencies).add(initializer);
    }
    
    static <R> NGConstructor create(Function<R> initializer, String... dependencies) {
        return create(JSFunction.create(initializer), dependencies);
    }
    
    static <R> NGConstructor create(JSFunction<R> initializer, String... dependencies) {
        return create(dependencies).add(initializer);
    }
    
    private static NGConstructor create(String... dependencies) {
        NGConstructor object = (NGConstructor) JavaScriptObject.createArray();
        if (dependencies != null) {
            for (String dependency : dependencies) {
                object.push(dependency);
            }
        }
        return object;
    }
    
    protected NGConstructor() {
    }
    
    private NGConstructor add(JavaScriptObject jso) {
        push(jso);
        return this;
    }

}
