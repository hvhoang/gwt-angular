package com.asayama.gwt.angular.client.location;

import com.asayama.gwt.angular.client.DefaultFactory;
import com.asayama.gwt.angular.client.Factory;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.Provider;
import com.google.gwt.core.client.JavaScriptObject;


public class LocationProvider implements Provider<Location> {

    @Injector.Inject
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

@Injector.Bind("$locationProvider")
class NGLocationProvider extends JavaScriptObject {

    protected NGLocationProvider() {
    }

    final native NGLocationProvider html5Mode(boolean isHtml5) /*-{
        return this.html5Mode(isHtml5);
    }-*/;
    
    final native NGLocationProvider hashPrefix(String prefix) /*-{
        return this.hashPrefix(prefix);
    }-*/;
}