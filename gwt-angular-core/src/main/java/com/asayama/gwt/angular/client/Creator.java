package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.rebind.CreatorGenerator;



/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link CreatorGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see CreatorGenerator
 * @param <T>
 */
public interface Creator<T> {
	T create(Class<? extends T> klass);
}