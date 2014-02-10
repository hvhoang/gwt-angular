package com.asayama.gwt.angular.rebind;

public class BinderGenerator extends AbstractGenerator {

	@Override
	String getFilename() {
		return "com/asayama/gwt/angular/rebind/BinderGenerator.vm";
	}

	@Override
	String getSuffix() {
		return "Generated";
	}

}
