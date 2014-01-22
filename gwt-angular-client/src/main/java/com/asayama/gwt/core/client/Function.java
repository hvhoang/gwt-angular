package com.asayama.gwt.core.client;

/**
 * Provides interface for Java callback from JSNI.
 * @author kyoken74
 * @see Invoker
 */
public interface Function<T extends $> {
	$ call(T jso);
}
