package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;

/**
 * ClientBundle can be registered directly to Module as Controller. This class
 * is unnecessary, only if the HtmlResource could be used directly in view.
 * 
 * @author kyoken74
 */
@Deprecated
public class CustomDirectiveExampleController implements Controller {

    public static final String DEMO_URL = CustomDirectiveExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Override
    public void onControllerLoad() {
    }
}
