package com.asayama.demo.client.examples;

import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.HashParam;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public class Example3Controller implements Controller {

	// Public final fields are directly bound to AngularJS's $scope
	public static final String TITLE = Example3Constants.INSTANCE.title();

	// Fields of type that implements Injectable are injected by the framework
	private RouteParams routeParams;
	private Location location;

	// Other fields are used to represent the state of this controller
	private String name;
	
	@Override
	public void onControllerLoad() {
		String name = routeParams.getString("name");
		setName(name);
	}
	
	public void onClickModify(String name) {
		List<HashParam> params = new ArrayList<HashParam>();
		params.add(new HashParam("name", name));
		location.setHashParam(params);
	}

	// Public getters and setters are automatically wired to AngularJS's $scope.

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
interface Example3Constants extends Constants {
	
	static final Example3Constants INSTANCE = GWT.create(Example3Constants.class);

	@DefaultStringValue("You can modify the URL hash parameter")
	String title();
}