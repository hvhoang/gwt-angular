package com.asayama.gwt.angular.client.annotations;

import com.asayama.gwt.angular.client.Module;

public @interface Depends {
	Class<? extends Module>[] value() default {};
	String[] ng() default {};
}
