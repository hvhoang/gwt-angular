package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.$;

public abstract class SuccessCallback<T extends $> extends PromiseCallback<T> {
	
	@Override
	public void onError(T object) {
		// noop by default
	}

}
