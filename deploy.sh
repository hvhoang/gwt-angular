#!/bin/sh

version=0.0.70-SNAPSHOT

jar xvf ~/GitHub/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular-web-${version}.war site/

rm -fr ${version}

mv site ${version}
