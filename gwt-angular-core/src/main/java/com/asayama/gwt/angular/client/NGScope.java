package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.jsni.client.JSON;

/**
 * https://github.com/kyoken74/gwt-angular/issues/6
 * @author kyoken74
 */
@Bind("$scope")
public class NGScope extends NGObject {

    protected NGScope() {
    }
    
    public final <T> T get(String key) {
        return this.<JSON>cast().getObject(key);
    }
    
    public final <T> void put(String key, T value) {
        this.<JSON>cast().put(key, value);
    }
    
    public final native void digest() /*-{
        if(!this.$$phase) {
          this.$digest();
        }
   }-*/;

}
