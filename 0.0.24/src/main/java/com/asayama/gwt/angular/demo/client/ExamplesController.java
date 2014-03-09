package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.demo.client.model.Page;
import com.asayama.gwt.angular.demo.client.model.Tab;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.util.Objects;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class ExamplesController implements Controller {

    // Services
    protected HttpClient http;
    protected RouteParams routeParams;
    protected Location location;
    
    @Bind("examplesURL")
    private String examplesURL;

    // Models
    private JSArray<Page> pages = null;
    private Page selectedPage = null;

    @Override
    public void onControllerLoad() {
        //TODO https://github.com/kyoken74/gwt-angular/issues/33
        final int pageIndex = Objects.coalesce(routeParams.getInteger("page"), 0);
        final int tabIndex = Objects.coalesce(routeParams.getInteger("tab"), 0);
        http.get(getExamplesURL(), new HttpClientCallback() {

            @Override
            public void onSuccess(Request request, Response response) {
                //TODO https://github.com/kyoken74/gwt-angular/issues/39
                pages = JSArray.eval(response.getText());
                setSelectedPage(pages.get(pageIndex));
                getSelectedPage().setSelectedTab(getSelectedPage().getTabs().get(tabIndex));
            }

            @Override
            public void onError(Request request, Exception exception) {
                //TODO https://github.com/kyoken74/gwt-angular/issues/40
                GWT.log(examplesURL, exception);
            }
        });
    }

    public void onClickPage(Page page) {
        selectedPage = page;
        // https://github.com/kyoken74/gwt-angular/issues/33
        if (getSelectedPage().getSelectedTab() == null) {
            getSelectedPage().setSelectedTab(getSelectedPage().getTabs().get(0));
        }
    }

    public void onClickTab(Tab tab) {
        getSelectedPage().setSelectedTab(tab);
        if (tab.getSource() != null) {
            return;
        }
        // https://github.com/kyoken74/gwt-angular/issues/33
        String url = getSelectedPage().getSelectedTab().getFilename();
        http.get(url, new HttpClientCallback() {

            @Override
            public void onSuccess(Request request, Response response) {
                getSelectedPage().getSelectedTab().setSource(
                        SafeHtmlUtils.htmlEscape(response.getText()));
            }

            @Override
            public void onError(Request request, Exception exception) {
            }
        });
    }

    public String isPageActive(Page page) {
        return page.equals(getSelectedPage()) ? "active" : "";
    }

    public String isTabActive(Tab tab) {
        return tab.equals(getSelectedPage().getSelectedTab()) ? "active" : "";
    }

    // Getters and Setters

    public JSArray<Page> getPages() {
        return pages;
    }

    public void setPages(JSArray<Page> examples) {
        this.pages = examples;
    }

    public Page getSelectedPage() {
        return selectedPage;
    }

    public void setSelectedPage(Page selectedPage) {
        this.selectedPage = selectedPage;
    }

    public String getExamplesURL() {
        return examplesURL;
    }
}
