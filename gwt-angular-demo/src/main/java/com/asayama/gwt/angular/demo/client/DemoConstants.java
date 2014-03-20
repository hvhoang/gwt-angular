package com.asayama.gwt.angular.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;


public interface DemoConstants extends Constants {

    public static final DemoConstants INSTANCE = GWT.create(DemoConstants.class);
    
    public String projectGroupId();
    public String projectArtifactId();
    public String projectVersion();
}
