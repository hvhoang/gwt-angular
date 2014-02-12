package com.asayama.demo.client.examples;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public class ExampleController0 implements Controller {

	// Public final fields are directly bound to AngularJS's $scope
	public static final String GREETING = Example1Constants.INSTANCE.greeting();
	public static final String STRANGER = Example1Constants.INSTANCE.stranger();

	// Other fields are used to represent the state of this controller
	private String name = null;
	
	@Override
	public void onControllerLoad() {
	}

	// Public getters and setters are automatically wired to AngularJS's $scope.

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
interface Example1Constants extends Constants {
	
	static final Example1Constants INSTANCE = GWT.create(Example1Constants.class);
	
	@DefaultStringValue("Hello")
	String greeting();
	
	@DefaultStringValue("Stranger")
	String stranger();
}