#!/bin/sh

version=0.0.31

jar xvf ~/Workspace/github.com/kyoken74/gwt-angular/gwt-angular-demo/target/gwt-angular-demo-${version}.war demo

rm -fr ${version}

mv demo ${version}
