package com.asayama.gwt.resources.client;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.ResourceGeneratorType;

@ResourceGeneratorType(ScriptResourceGenerator.class)
public interface ScriptResource extends ResourcePrototype {
    boolean ensureInjected();
    String getText();
}
