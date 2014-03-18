package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class HttpClientExampleController implements Controller {

    public static final String DEMO_URL =
            HttpClientExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            HttpClientExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            HttpClientExampleResources.INSTANCE.java().getText());

    // Fields of type Injectable are injected by the framework
    
    private HttpClient http;

    // Other fields are used to represent the state of this controller

    private Customers customers;

    @Override
    public void onControllerLoad() {
        String url = "partials/examples/HttpClientExample.json";
        HttpClientCallback callback = new HttpClientCallback() {
            @Override
            public void onSuccess(Request request, Response response) {
                Customers customers = Customers.parse(response.getText());
                setCustomers(customers);
            }

            @Override
            public void onError(Request request, Exception exception) {
                GWT.log("onError", exception);
            }
        };
        http.get(url, callback);
    }

    // Public getters and setters are automatically wired to AngularJS's $scope.

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
}

/**
 * Represents a model object.
 */
class Customers extends JSON {

    protected Customers() {
    }
}

interface HttpClientExampleResources extends ClientBundle {

    static final HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("HttpClientExampleDemo.html")
    public DataResource demo();

    @Source("HttpClientExampleDemo.html")
    public TextResource html();
    
    @Source("HttpClientExampleController.java")
    public TextResource java();
}