package com.asayama.demo.client.model;

import com.google.gwt.core.client.JsArray;

public class ItemList extends JsArray<Item> {

	protected ItemList() {
	}
	
	public final Item getById(String id) {
		if (id == null) {
			return null;
		}
		for (int i = 0; i < length(); i++) {
			Item item = get(i);
			if (item != null) {
				String itemId = item.getId();
				if (itemId != null && itemId.equals(id)) {
					return item;
				}
			}
		}
		return null;
	}

}
