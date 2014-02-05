package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;

/**
 * Warning: Do not implement this interface in JavaScriptObject extensions.
 * <p>
 * com.google.gwt.dev.jjs.InternalCompilerException: Already seen an 
 * implementing JSO subtype (Http) for interface (Constructor) while examining
 * newly-added type (Q). This is a bug in JSORestrictionsChecker.
 * </p>
 * <p>
 * See also https://code.google.com/p/google-web-toolkit/issues/detail?id=4859
 * </p>
 */
@Deprecated
public interface Constructable {
	JSObject construct(Invoker invoker);
}
