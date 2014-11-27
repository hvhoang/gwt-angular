package com.asayama.gwt.jquery.client;

import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class JQuery implements EntryPoint {
    
    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
        	JQueryScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}

/**
 * Usage:
 * <p>
 * {@code JQueryScripts.INSTANCE.script().ensureInjected(JSObject.$wnd); }
 * </p>
 * 
 * @author kyoken74
 */
interface JQueryScripts extends ClientBundle {

	static JQueryScripts INSTANCE = GWT.create(JQueryScripts.class);
	
	@Source("bower_components/jquery/dist/jquery.min.js")
	ScriptResource script();
}
