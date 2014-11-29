package com.asayama.gwt.resources.client;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.ResourceGeneratorType;

@ResourceGeneratorType(StyleResourceGenerator.class)
public interface StyleResource extends ResourcePrototype {
    String getText();
    boolean ensureInjected();
    boolean ensureInjected(boolean immediate);
}
