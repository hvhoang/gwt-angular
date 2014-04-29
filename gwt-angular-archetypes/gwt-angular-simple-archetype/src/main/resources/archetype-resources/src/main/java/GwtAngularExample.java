#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;

public class GwtAngularExample extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        controller(GwtAngularExampleController.class);
    }
}
