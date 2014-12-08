package com.asayama.gwt.angular.client.location;

import com.asayama.gwt.angular.client.DefaultFactory;
import com.asayama.gwt.angular.client.Factory;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Provider;


public class LocationProvider implements Provider<Location> {

    NGLocationProvider ngo;
    
    @Override
    public Factory<Location> getFactory() {
    	return new DefaultFactory<Location>(Location.class);
    }
    
    public LocationProvider html5Mode(boolean isHtml5) {
        ngo.html5Mode(isHtml5);
        return this;
    }
    
    public LocationProvider hashPrefix(String prefix) {
        ngo.hashPrefix(prefix);
        return this;
    }
}

@Injector.Inject("$locationProvider")
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