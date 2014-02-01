package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;

/**
 * This class was deprecated because it cannot be supported by JSObject 
 * extensions. When this interface was implemented by both Http and Q objects,
 * both of which are JSObect subtypes, an exception similar to the one below 
 * was thrown, and the program refused to continue.
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
