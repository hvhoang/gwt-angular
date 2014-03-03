package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

public class JumbotronController extends AbstractController {

    // Services
    protected HttpClient http;
    protected RouteParams routeParams;
    protected Location location;
    
    @Bind("examplesURL")
    private String examplesURL;

    // Models
    private Examples examples = null;

    @Override
    public void onControllerLoad() {
        
        log.debug("calling ExamplesController.onControllerLoad()");
        
        // https://github.com/kyoken74/gwt-angular/issues/33
        http.get(getExamplesURL(), new HttpClientCallback() {

            @Override
            public void onSuccess(Request request, Response response) {
                examples = Examples.parse(response.getText());
            }

            @Override
            public void onError(Request request, Exception exception) {
            }
        });
    }

    // Getters and Setters

    public Examples getExamples() {
        return examples;
    }

    public void setExamples(Examples examples) {
        this.examples = examples;
    }

    public String getExamplesURL() {
        return examplesURL;
    }
}
