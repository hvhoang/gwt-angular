#!/bin/sh

version=0.0.50-SNAPSHOT

jar xvf ~/Workspace/github.com/kyoken74/gwt-angular/gwt-angular-site/target/gwt-angular.war site/

rm -fr ${version}

mv site ${version}
