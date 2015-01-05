package com.asayama.gwt.angular.client;


/**
 * Provides an abstract implementation of {@link Controller} interface. Since
 * GWT Angular provides binding of public properties and methods to Angular's
 * $scope behind the scenes, many implementations of {@code Controller} objects
 * do not need to perform any meaningful tasks during 
 * {@link #onControllerLoad()}. This abstract implementation provides a no-op
 * implementation of {@link #onControllerLoad()}.
 * 
 * @author kyoken74
 */
public abstract class AbstractController implements Controller {

    /**
     * Equivalent of AngularJS {@code $scope}.
     */
    @Injector.Inject("$scope")
    protected NGScope scope;
    
    /**
     * No-op implementation.
     */
    @Override
    public void onControllerLoad() {
        //noop
    }
}
