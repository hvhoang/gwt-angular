#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.asayama.gwt.angular.client.Controller;

public class GwtAngularExampleController implements Controller {

    // Public final fields are directly bound to AngularJS's ${symbol_dollar}scope, and they 
    // are available for use in the HTML.
    
    public static final String GREETING = "Hello";
    public static final String STRANGER = "Stranger";

    // Other fields are used to represent the state of this controller.
    
    private String name = null;

    @Override
    public void onControllerLoad() {
        //noop
    }

    // Public methods are automatically wired to AngularJS's ${symbol_dollar}scope, and
    // they are availabe for use in the HTML.
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
