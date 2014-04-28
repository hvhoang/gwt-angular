package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;

@Deprecated
public class HttpClientExampleController implements Controller {

    public static final String DEMO_URL = HttpClientExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Override
    public void onControllerLoad() {
    }
}
