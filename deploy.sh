#!/bin/sh

version=0.0.70-SNAPSHOT

jar xvf ~/GitHub/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular-web-${version}.war site

node sitemap.js
node snapshots.js

