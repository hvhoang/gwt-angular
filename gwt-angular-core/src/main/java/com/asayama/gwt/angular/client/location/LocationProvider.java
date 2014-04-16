package com.asayama.gwt.angular.client.location;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Provider;


public class LocationProvider implements Provider {

    NGLocationProvider ngo;
    
    public LocationProvider html5Mode(boolean isHtml5) {
        ngo.html5Mode(isHtml5);
        return this;
    }
    
    public LocationProvider hashPrefix(String prefix) {
        ngo.hashPrefix(prefix);
        return this;
    }
}

@Bind("$locationProvider")
class NGLocationProvider extends NGObject {

    protected NGLocationProvider() {
    }

    final native NGLocationProvider html5Mode(boolean isHtml5) /*-{
        return this.html5Mode(isHtml5);
    }-*/;
    
    final native NGLocationProvider hashPrefix(String prefix) /*-{
        return this.hashPrefix(prefix);
    }-*/;
}