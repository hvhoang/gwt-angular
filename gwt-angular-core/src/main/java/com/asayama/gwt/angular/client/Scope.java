package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;

public class Scope implements Injectable {
    
    private Scope ngo;
    
    public void digest() {
        ngo.digest();
    }
}

@Bind("$scope")
class NGScope extends NGObject {

    protected NGScope() {
    }

    public final native void digest() /*-{
        if(!this.$$phase) {
          this.$digest();
        }
   }-*/;

}
