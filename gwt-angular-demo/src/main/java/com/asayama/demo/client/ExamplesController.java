package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.util.Objects;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class ExamplesController implements Controller {

	public static final String DEFAULT_PAGE = "Example 1";
	public static final String DEFAULT_TAB = "Demo";
	
	private RouteParams routeParams;
	private Location location;
	
	private JsArrayString pages = (JsArrayString) JavaScriptObject.createArray();
	private JsArrayString tabs = (JsArrayString) JavaScriptObject.createArray();

	private String selectedPage = DEFAULT_PAGE;
	private String selectedTab = DEFAULT_TAB;
	
	public ExamplesController() {
		tabs.push("Demo");
		tabs.push("HTML");
		tabs.push("Java");
		tabs.push("Data");
		pages.push("Example 1");
		pages.push("Example 2");
		pages.push("Example 3");
		pages.push("Example 4");
	}
	
	@Override
	public void onControllerLoad() {
		selectedPage = Objects.coalesce(routeParams.getString("page"), DEFAULT_PAGE);
		selectedTab = Objects.coalesce(routeParams.getString("tab"), DEFAULT_TAB);
	}

	public void onClickPage(String page) {
		selectedPage = page;
		location.setHashParam("page", page);
	}
	
	public void onClickTab(String tab) {
		selectedTab = tab;
		location.setHashParam("tab", tab);
	}
	
	public String isPageActive(String page) {
		return page.equals(selectedPage) ? "active" : "";
	}
	
	public String isTabActive(String tab) {
		return tab.equals(selectedTab) ? "active" : "";
	}
	
	// Getters and Setters
	
	public JsArrayString getPages() {
		return pages;
	}
	public JsArrayString getTabs() {
		return tabs;
	}

}
