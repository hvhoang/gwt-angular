package com.asayama.gwt.angular.client.annotations;


public @interface Depends {
	Class<?>[] value() default {};
	String[] name() default {};
}
