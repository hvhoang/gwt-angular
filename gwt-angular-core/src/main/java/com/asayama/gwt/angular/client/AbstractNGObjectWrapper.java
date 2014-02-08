package com.asayama.gwt.angular.client;

/**
 * <h1>This class is not yet supported</h1>
 * This class does not work yet. Module.config and Module.factory somehow do
 * not recognize this class when calling the wrap method. If the descendants
 * of this class end up throwing IllegalStateException because the fact that
 * they implement NGObjectWrapper is lost.
 */
@Deprecated
public abstract class AbstractNGObjectWrapper<T extends NGObject> implements NGObjectWrapper<T> {

	private T ngo = null;
	
	@Override
	public final void wrap(T ngo) {
		this.ngo = ngo;
	}
	
	protected T getNGObject() throws IllegalStateException {
		if (this.ngo == null) {
			String classname = this.getClass().getName();
			throw new IllegalStateException(classname +
					" has not been initialized. Have you forgotten to register the component with your module?");
		}
		return this.ngo;
	}

}
