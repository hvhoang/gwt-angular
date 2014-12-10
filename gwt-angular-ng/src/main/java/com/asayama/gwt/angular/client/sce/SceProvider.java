package com.asayama.gwt.angular.client.sce;

import com.asayama.gwt.angular.client.Factory;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.Service;
import com.google.gwt.core.client.JavaScriptObject;

public class SceProvider implements Provider<Service> {

    @Injector.Inject
    private NGSceProvider ngo;

    public boolean enabled(boolean isEnabled) {
        return ngo.enabled(isEnabled);
    }
    
    @Override
    public Factory<Service> getFactory() {
        return null;
    }
}

@Injector.Bind("$sceProvider")
class NGSceProvider extends JavaScriptObject {

    protected NGSceProvider() {
    }

    final native boolean enabled(boolean isEnabled) /*-{
        return this.enabled(isEnabled);
    }-*/;
}
