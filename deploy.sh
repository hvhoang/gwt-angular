#!/bin/sh

version=0.0.65-patch.1

#jar xvf ~/Developer/GitHub/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war sitemap.xml

jar xvf ~/Developer/GitHub/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war site/

rm -fr ${version}

mv site ${version}
