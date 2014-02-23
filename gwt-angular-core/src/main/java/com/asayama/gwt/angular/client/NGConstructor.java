package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;

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
class NGConstructor extends JSArray<Object> {

    static NGConstructor create(Closure initializer, String... dependencies) {
        return create(JSClosure.create(initializer), dependencies);
    }
    
    static NGConstructor create(JSClosure initializer, String... dependencies) {
        NGConstructor object = create(dependencies);
        object.add(initializer);
        return object;
    }
    
    static <R> NGConstructor create(Function<R> initializer, String... dependencies) {
        return create(JSFunction.create(initializer), dependencies);
    }
    
    static <R> NGConstructor create(JSFunction<R> initializer, String... dependencies) {
        NGConstructor object = create(dependencies);
        object.add(initializer);
        return object;
    }
    
    private static NGConstructor create(String... dependencies) {
        NGConstructor object = NGConstructor.create().cast();
        if (dependencies != null) {
            for (String dependency : dependencies) {
                object.add(dependency);
            }
        }
        return object;
    }
    
    protected NGConstructor() {
    }
    
}
