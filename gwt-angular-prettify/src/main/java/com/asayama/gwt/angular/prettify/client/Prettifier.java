package com.asayama.gwt.angular.prettify.client;

import com.asayama.gwt.angular.client.Service;

/**
 * GWT Angular service wrapper around Google Code Prettify. In order to use this
 * service, you must include the following line in your GWT module.
 * 
 * <pre>
 * {@code <inherits name="com.asayama.gwt.angular.prettify.Prettify" />}
 * </pre>
 * 
 * @since 0.1.1
 * @author kyoken74
 * @see com.asayama.gwt.angular.prettify.client.directive.GwtPrettify
 * @see com.asayama.gwt.angular.prettify.client.directive.Prettyprint
 * @see com.asayama.gwt.angular.prettify.client.filter.Prettify
 */
public class Prettifier implements Service {

    public native String prettify(String input) /*-{
        return $wnd.prettyPrintOne(input);
    }-*/;
}
