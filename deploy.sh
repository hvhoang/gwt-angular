#!/bin/sh

version=0.0.61-SNAPSHOT

#jar xvf ~/Developer/Workspace/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war sitemap.xml

jar xvf ~/Developer/Workspace/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war site/

rm -fr ${version}

mv site ${version}
