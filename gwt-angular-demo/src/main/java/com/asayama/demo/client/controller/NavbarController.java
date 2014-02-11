package com.asayama.demo.client.controller;

import com.asayama.demo.client.model.ListItem;
import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;

/**
 * In this class, we do not use the Location service from AngularJS because the
 * navbar.html is outside of the {@code <div data-ng-view></div>}.
 */
public class NavbarController implements Controller {

	private ListItem selectedListItem = null;
	private JsArray<ListItem> listItems = (JsArray<ListItem>) JavaScriptObject.createArray();

	@Override
	public void onControllerLoad() {
		listItems.push(ListItem.create().setCaption("Example 1").setRoute("/example1"));
		listItems.push(ListItem.create().setCaption("Example 2").setRoute("/example2"));
		listItems.push(ListItem.create().setCaption("Example 3").setRoute("/example3"));
		listItems.push(ListItem.create().setCaption("Example 4").setRoute("/example4"));
		String hash = Window.Location.getHash().substring(1);
		for (int i = 0; i < listItems.length(); i++) {
			ListItem listItem = listItems.get(i);
			if (listItem.getRoute().equals(hash)) {
				selectedListItem = listItem;
			}
		}
		if (selectedListItem == null) {
			selectedListItem = listItems.get(0);
		}
	}
	
	// Events
	
	public void onSelectedItem(ListItem listItem) {
		setSelectedListItem(listItem);
	}

	// Getters and Setters
	
	public ListItem getSelectedListItem() {
		return selectedListItem;
	}
	
	public void setSelectedListItem(ListItem selectedListItem) {
		this.selectedListItem = selectedListItem;
	}
	
	public JsArray<ListItem> getListItems() {
		return listItems;
	}
	
	public void setListItems(JsArray<ListItem> listItems) {
		this.listItems = listItems;
	}

}
