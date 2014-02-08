package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

public class Q implements Service, NGObjectWrapper {

	protected NGQ delegate;
	
	public <T extends JSObject> Deferred defer() {
		Deferred deferred = new Deferred();
		deferred.delegate = delegate._defer();
		return deferred;
	}

	@Override
	public void wrap(NGObject ngo) {
		this.delegate = NGObject.cast(ngo);
	}

}
@Bind("$q")
class NGQ extends NGObject {

	protected NGQ(){
	}
	
	final native DeferredJSO _defer() /*-{
		return this.defer();
	}-*/;

}
