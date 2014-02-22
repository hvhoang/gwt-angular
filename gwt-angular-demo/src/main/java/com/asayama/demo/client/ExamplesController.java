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
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class ExamplesController implements Controller {

	public static final String EXAMPLES_DATA = "myapp/partials/examples.json";
	
	private HttpClient http;
	private RouteParams routeParams;
	private Location location;
	
	private Examples examples = null;
	private Page selectedPage = null;
	
	@Override
	public void onControllerLoad() {
		final int pageIndex = Objects.coalesce(routeParams.getInteger("page"), 0);
		final int tabIndex = Objects.coalesce(routeParams.getInteger("tab"), 0);
		try {
			http.get(EXAMPLES_DATA, new HttpClientCallback() {
				@Override
				public void onSuccess(Request request, Response response) {
					examples = Examples.parse(response.getText());
					setSelectedPage(examples.getPages().get(pageIndex));
					getSelectedPage().setSelectedTab(selectedPage.getTabs().get(tabIndex));
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
		if (getSelectedPage().getSelectedTab() == null) {
			getSelectedPage().setSelectedTab(getSelectedPage().getTabs().get(0));
		}
	}
	
	public void onClickTab(Tab tab) {
		getSelectedPage().setSelectedTab(tab);
		try {
			if (tab.getSource() == null) {
				http.get(getSelectedPage().getSelectedTab().getFilename(), new HttpClientCallback() {
					@Override
					public void onSuccess(Request request, Response response) {
						getSelectedPage().getSelectedTab().setSource(SafeHtmlUtils.htmlEscape(response.getText()));
					}
					@Override
					public void onError(Request request, Exception exception) {
					}
				});
			}
		} catch (RequestException e) {
			GWT.log("Exception while ExamplesController.onClickTab", e);
		}
	}
	
	public String isPageActive(Page page) {
		return page.equals(getSelectedPage()) ? "active" : "";
	}
	
	public String isTabActive(Tab tab) {
		return tab.equals(getSelectedPage().getSelectedTab()) ? "active" : "";
	}
	
	// Getters and Setters
	
	public Examples getExamples() {
		return examples;
	}
	public void setExamples(Examples examples) {
		this.examples = examples;
	}
	public Page getSelectedPage() {
		return selectedPage;
	}
	public void setSelectedPage(Page selectedPage) {
		this.selectedPage = selectedPage;
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
	final void setSelectedTab(Tab tab) {
		putObject("selectedTab", tab);
	}
	final Tab getSelectedTab() {
		return getObject("selectedTab");
	}
}
class Tab extends JSObject {
	protected Tab() {}
	final String getDisplayName() {
		return getString("displayName");
	}
	final String getTemplate() {
		return getString("template");
	}
	final String getFilename() {
		return getString("filename");
	}
	final String getSource() {
		return getString("source");
	}
	final void setSource(String source) {
		putString("source", source);
	}
}
