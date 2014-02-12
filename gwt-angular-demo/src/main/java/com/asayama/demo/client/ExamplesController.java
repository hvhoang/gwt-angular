package com.asayama.demo.client;

import com.asayama.demo.client.model.Item;
import com.asayama.demo.client.model.ItemList;
import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.util.Objects;
import com.google.gwt.core.client.JavaScriptObject;

public class ExamplesController implements Controller {

	public static final String DEFAULT_PAGE_ID = "0";
	public static final String DEFAULT_TAB_ID = "0";
	
	private RouteParams routeParams;
	private Location location;
	
	private ItemList pages = (ItemList) JavaScriptObject.createArray();
	private ItemList tabs = (ItemList) JavaScriptObject.createArray();

	private Item selectedPage;
	private Item selectedTab;
	
	public ExamplesController() {
		initTabs();
		initPages();
	}
	
	@Override
	public void onControllerLoad() {
		String pageId = Objects.coalesce(routeParams.getString("pageId"), DEFAULT_PAGE_ID);
		String tabId = Objects.coalesce(routeParams.getString("tabId"), DEFAULT_TAB_ID);
		selectedPage = pages.getById(pageId);
		selectedTab = tabs.getById(tabId);
		if (selectedPage == null && pages.length() > 0) {
			selectedPage = pages.get(0);
		}
		if (selectedTab == null && tabs.length() > 0) {
			selectedTab = tabs.get(0);
		}
	}
	
	private void initTabs() {
		tabs.push(Item.<Item>create().setId("0").setDisplayName("Demo"));
		tabs.push(Item.<Item>create().setId("1").setDisplayName("HTML"));
		tabs.push(Item.<Item>create().setId("2").setDisplayName("Java"));
		tabs.push(Item.<Item>create().setId("3").setDisplayName("Data"));
	}
	
	private void initPages() {
		pages.push(Item.<Item>create().setId("0").setDisplayName("Example 0"));
		pages.push(Item.<Item>create().setId("1").setDisplayName("Example 1")); 
		pages.push(Item.<Item>create().setId("2").setDisplayName("Example 2"));
		pages.push(Item.<Item>create().setId("3").setDisplayName("Example 3"));
	}

	public void onClickPage(Item page) {
		selectedPage = page;
		location.setHashParam("pageId", page.getId());
	}
	
	public void onClickTab(Item tab) {
		selectedTab = tab;
		location.setHashParam("tabId", tab.getId());
	}
	
	public String isPageActive(Item page) {
		return page.equals(selectedPage) ? "active" : "";
	}
	
	public String isTabActive(Item tab) {
		return tab.equals(selectedTab) ? "active" : "";
	}
	
	// Getters and Setters
	
	public ItemList getPages() {
		return pages;
	}
	public ItemList getTabs() {
		return tabs;
	}

}
