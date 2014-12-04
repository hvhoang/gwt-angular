#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface MyResources extends ClientBundle {

    static final MyResources INSTANCE = GWT.create(MyResources.class);
    
    @Source("MyView.html")
    HtmlResource MyView();
}
