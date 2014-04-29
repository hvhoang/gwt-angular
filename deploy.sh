#!/bin/sh

version=0.0.60

#jar xvf ~/Developer/Workspace/github.com/kyoken74/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war sitemap.xml

jar xvf ~/Developer/Workspace/github.com/kyoken74/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war site/

rm -fr ${version}

mv site ${version}
