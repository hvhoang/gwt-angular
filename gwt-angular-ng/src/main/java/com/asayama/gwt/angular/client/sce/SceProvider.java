package com.asayama.gwt.angular.client.sce;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Provider;
import com.google.gwt.core.client.GWT;

public class SceProvider implements Provider {

    private NGSceProvider ngo;

    public boolean enabled(boolean isEnabled) {
    	if (!isEnabled) {
    		GWT.log("Strict Contextual Escaping (SCE) has been disabled. This "
    				+ "may present a security risk to your application.");
    	}
    	return ngo.enabled(isEnabled);
    }
}

@Bind("$sceProvider")
class NGSceProvider extends NGObject {

    protected NGSceProvider() {
    }

    final native boolean enabled(boolean isEnabled) /*-{
    	return this.enabled(isEnabled);
    }-*/;
}
