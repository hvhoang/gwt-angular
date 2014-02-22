package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.annotations.Depends;

@Depends(ng = { "ngRoute", "ngSanitize" })
public class MyModule extends Module {
}
