#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface GwtAngularExampleResources extends ClientBundle {

    static final GwtAngularExampleResources INSTANCE = GWT.create(GwtAngularExampleResources.class);
    
    static final String DEMO_URL = GwtAngularExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Source("view/GwtAngularExampleDocumentation.html")
    HtmlResource GwtAngular();

    @Source("view/GwtAngularExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/GwtAngularExample.gwt.xml")
    TextResource config();

    @Source("GwtAngularExample.java")
    TextResource module();
    
    @Source("GwtAngularExampleController.java")
    TextResource controller();
    
    @Source("view/GwtAngularExample.html")
    TextResource view();
}
