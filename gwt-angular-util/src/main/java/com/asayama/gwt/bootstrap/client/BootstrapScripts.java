package com.asayama.gwt.bootstrap.client;

import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * Usage:
 * <p>
 * {@code BootstrapScripts.INSTANCE.script().ensureInjected(JSObject.$wnd); }
 * </p>
 * 
 * @author kyoken74
 */
public interface BootstrapScripts extends ClientBundle {

	static BootstrapScripts INSTANCE = GWT.create(BootstrapScripts.class);
	
	@Source("bootstrap.min.js")
	ScriptResource script();
}
