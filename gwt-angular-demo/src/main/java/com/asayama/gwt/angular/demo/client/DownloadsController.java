package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.demo.client.model.RepoTag;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

public class DownloadsController implements Controller {

    // Services
    protected HttpClient http;
    
    @Bind("downloadsURL")
    private String downloadsURL;
    
    // Models
    private JSArray<RepoTag> previousTags;
    private RepoTag latestTag;
    
    @Override
    public void onControllerLoad() {
        http.get(getDownloadsURL(), new HttpClientCallback() {

            @Override
            public void onSuccess(Request request, Response response) {
                //TODO https://github.com/kyoken74/gwt-angular/issues/39
                JSArray<RepoTag> tags = JSArray.eval(response.getText());
                if (tags != null && tags.size() > 0) {
                    setLatestTag(tags.get(0));
                    tags.remove(0);
                    setPreviousTags(tags);
                }
            }

            @Override
            public void onError(Request request, Exception exception) {
                //TODO https://github.com/kyoken74/gwt-angular/issues/40
                GWT.log(downloadsURL, exception);
            }
        });
    }

    // Getters and Setters
    
    public String getDownloadsURL() {
        return downloadsURL;
    }
    
    public JSArray<RepoTag> getPreviousTags() {
        return previousTags;
    }
    
    public void setPreviousTags(JSArray<RepoTag> tags) {
        this.previousTags = tags;
    }
    
    public RepoTag getLatestTag() {
        return latestTag;
    }
    
    public void setLatestTag(RepoTag latestTag) {
        this.latestTag = latestTag;
    }
}
