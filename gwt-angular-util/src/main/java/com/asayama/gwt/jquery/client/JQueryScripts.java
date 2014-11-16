package com.asayama.gwt.jquery.client;

import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * Usage:
 * <p>
 * {@code JQueryScripts.INSTANCE.script().ensureInjected(JSObject.$wnd); }
 * </p>
 * 
 * @author kyoken74
 */
public interface JQueryScripts extends ClientBundle {

	static JQueryScripts INSTANCE = GWT.create(JQueryScripts.class);
	
	@Source("jquery-1.10.2.min.js")
	ScriptResource script();
}
