package com.asayama.gwt.angular.route.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.jsni.client.JSObject;

public class RouteParams implements Service {

    private NGRouteParams ngo;

    public String getString(String key) {
        return ngo.getStringParam(key);
    }

    public Integer getInteger(String key) {
        return ngo.getIntegerParam(key);
    }

    public Double getDouble(String key) {
        return ngo.getDoubleParam(key);
    }

    public Date getDate(String key) {
        return ngo.getDateParam(key);
    }

    public <T extends JSObject> T getObject(String key) {
        return ngo.getObjectParam(key);
    }
}

@Bind("$routeParams")
class NGRouteParams extends NGObject {

    protected NGRouteParams() {
    }

    public final String getStringParam(String key) {
        return $string(key);
    }

    public final Integer getIntegerParam(String key) {
        return $integer(key);
    }

    public final Double getDoubleParam(String key) {
        return $double(key);
    }

    public final Date getDateParam(String key) {
        return $date(key);
    }

    public final <T extends JSObject> T getObjectParam(String key) {
        return $jsobject(key);
    }
}
