package com.asayama.gwt.core.client;

/**
 * Invokes a function that is assigned to it at the time of construction. This
 * class is intended to be used as a callback mechanism from JSNI.
 * <pre>
public void callJava() {
  callJSNI(name, new Invoker&lt;$>(new Function&lt;$>() {
    public $ invoke($ fooObject) {
      GWT.log(fooObject.name); //prints 'foo' to GWT log
      return fooObject;
    }
  }));
}

final native void callJSNI(String name, Invoker<$> invoker) /*-{
  var fooObject = { name:'foo' };
  invoker.@com.asayama.gwt.core.client.Invoker::
    invoke(Lcom/asayama/gwt/core/client/$;)(fooObject));
}-*&#47;
 * </pre>
 * @author kyoken74
 */
public class Invoker<T extends $> {
	
	final Function<T> delegate;
	
	public Invoker(Function<T> delegate) {
		this.delegate = delegate;
	}
	
	public $ invoke(T jso) {
		return delegate.call(jso);
	}
}
