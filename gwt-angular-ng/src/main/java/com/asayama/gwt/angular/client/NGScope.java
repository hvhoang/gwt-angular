package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.jsni.client.JSObject;

/**
 * https://github.com/kyoken74/gwt-angular/issues/6
 * @author kyoken74
 */
@Injector.Inject("$scope")
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
