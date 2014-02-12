package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSObject;
import com.asayama.gwt.core.client.util.Objects;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class ExamplesController implements Controller {

	private HttpClient http;
	private RouteParams routeParams;
	private Location location;
	
	private Examples examples = null;
	private Page selectedPage = null;
	private Tab selectedTab = null;
	
	@Override
	public void onControllerLoad() {
		final int pageIndex = Objects.coalesce(routeParams.getInteger("page"), 0);
		final int tabIndex = Objects.coalesce(routeParams.getInteger("tab"), 0);
		try {
			http.get("partials/examples.json", new HttpClientCallback() {
				@Override
				public void onSuccess(Request request, Response response) {
					examples = Examples.parse(response.getText());
					selectedPage = examples.getPages().get(pageIndex);
					selectedTab = selectedPage.getTabs().get(tabIndex);
				}
				@Override
				public void onError(Request request, Exception exception) {
				}
			});
		} catch (RequestException e) {
			GWT.log("Exception while ExamplesController.onControllerLoad", e);
		}
	}
	
	public void onClickPage(Page page) {
		selectedPage = page;
		selectedTab = page.getTabs().get(0);
	}
	
	public void onClickTab(Tab tab) {
		selectedTab = tab;
	}
	
	public String isPageActive(Page page) {
		return page.equals(selectedPage) ? "active" : "";
	}
	
	public String isTabActive(Tab tab) {
		return tab.equals(selectedTab) ? "active" : "";
	}
	
	// Getters and Setters
	
	public Examples getExamples() {
		return examples;
	}
	public Page getSelectedPage() {
		return selectedPage;
	}
	public Tab getSelectedTab() {
		return selectedTab;
	}

}
class Examples extends JSObject {
	protected Examples() {}
	final JsArray<Page> getPages() {
		return getObject("pages").cast();
	}
}
class Page extends JSObject {
	protected Page() {}
	final JsArray<Tab> getTabs() {
		return getObject("tabs").cast();
	}
}
class Tab extends JSObject {
	protected Tab() {}
}