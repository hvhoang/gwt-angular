package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.user.client.Event;


public class TutorialController extends AbstractController {

    private JSArray<Entry> entries;
    private String quickEntryInputValue;
    
    @Override
    public void onControllerLoad() {
        JSArray<Entry> entries = JSArray.create();
        setEntries(entries);
    }
    
    public void onChangeQuickEntry(String quickEntryInputValue) {
        setQuickEntryInputValue(quickEntryInputValue);
    }
    
    public void onKeyPressQuickEntry(Event event) {
        int keyCode = event.getKeyCode();
        if (keyCode == 13) {
            getEntries().add(Entry.create(quickEntryInputValue));
            setQuickEntryInputValue("");
        }
    }
    
    public JSArray<Entry> getEntries() {
        return entries;
    }
    
    public void setEntries(JSArray<Entry> entries) {
        this.entries = entries;
    }
    
    public String getQuickEntryInputValue() {
        return quickEntryInputValue;
    }
    
    public void setQuickEntryInputValue(String quickEntryInputValue) {
        this.quickEntryInputValue = quickEntryInputValue;
    }
}

class Entry extends JSON {

    public static Entry create(String caption) {
        Entry entry = JSON.create();
        entry.setCaption(caption);
        return entry;
    }
    
    protected Entry() {
    }
    
    public final void setCaption(String caption) {
        put("caption", caption);
    }
}