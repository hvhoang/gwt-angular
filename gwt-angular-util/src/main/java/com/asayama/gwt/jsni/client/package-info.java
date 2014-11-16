/**
 * Provides core components needed for GWT development. GWT's JavaScriptObject
 * interface is often not sufficient when wrapping an complex JavaScript
 * framework. There are often need to pass objects that are not descedants of
 * JavaScriptObject to the native layer via either closures or arrays, which
 * JavaScriptObject does not handle very well. This package is provided so that
 * it is easier to communicate with the native JavaScript layer bypassing some
 * of these limitations.
 * <p>
 * In order to use the components in this module, the user must add the 
 * following inherit statements in his or code.
 * </p>
 * <pre>{@code
 * <inherits name="com.asayama.gwt.jsni.JSNI" />
 * }</pre>
 */
package com.asayama.gwt.jsni.client;
