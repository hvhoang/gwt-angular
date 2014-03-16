/**
 * @author kyoken74
 */
package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.core.client.JSON;

class Page extends JSON {

    protected Page() {
    }

    public final String getTitle() {
        return getString("title");
    }
    
    public final String getFilename() {
        return getString("filename");
    }
}

