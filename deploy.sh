#!/bin/sh

version=0.0.29

jar xvf ~/Developer/Workspace/github/kyoken74/gwt-angular/gwt-angular-demo/target/gwt-angular-demo-${version}.war demo

rm -fr ${version}

mv demo ${version}
