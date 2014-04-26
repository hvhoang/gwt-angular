package com.asayama.gwt.resources.client;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.ResourceGeneratorType;
import com.google.gwt.safehtml.shared.SafeUri;

@ResourceGeneratorType(HtmlResourceGenerator.class)
public interface HtmlResource extends ResourcePrototype {

    SafeUri getSafeUri();
}
