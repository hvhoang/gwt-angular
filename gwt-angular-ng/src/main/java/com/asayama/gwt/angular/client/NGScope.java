package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.jsni.client.JSObject;

/**
 * Provides GWT Java interface for AngularJS's {@code $scope} object. In order
 * to inject {@code $scope} into your Angular component, you can simply declare
 * it as a component's property, and annotate it with {@code @Injector.Inject},
 * e.g.
 * <pre>
 * public class MyController implements Controller {
 * 
 *   {@code @Injector.Inject}
 *   NGScope scope;
 *   
 *   public void onControllerLoad() {
 *     scope.put("name", "World!");
 *   }
 * }
 * </pre>
 * 
 * Another use of this interface is to inject {@code $rootScope} into your
 * Angular component, e.g.
 * <pre>
 * public class MyRunnable implements Runnable {
 * 
 *   {@code @Injector.Inject}("$rootScope")
 *   NGScope scope;
 *   
 *   public void run() {
 *     scope.put("greeting", "Hello");
 *   }
 * }
 * </pre>
 * 
 * @author kyoken74
 */
@Injector.Bind("$scope")
public class NGScope extends JSON {

    @SuppressWarnings("unchecked")
    public static NGScope create() {
        NGScope instance = JSObject.create();
        return instance;
    }

    protected NGScope() {
    }
    
    public final <T> T get(String key) {
        return this.getObject(key);
    }
    
    public final native void digest() /*-{
        if(!this.$$phase) {
          this.$digest();
        }
   }-*/;

}
