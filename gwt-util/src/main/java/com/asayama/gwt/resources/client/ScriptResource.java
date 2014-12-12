package com.asayama.gwt.resources.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.DefaultExtensions;
import com.google.gwt.resources.ext.ResourceGeneratorType;

@DefaultExtensions(value = {".js"})
@ResourceGeneratorType(ScriptResourceGenerator.class)
public interface ScriptResource extends ResourcePrototype {
    String getText();
    boolean ensureInjected();
    boolean ensureInjected(JavaScriptObject wnd);
}
