#!/bin/sh

version=0.0.72-SNAPSHOT

jar xvf ~/GitHub/gwt-angular/gwt-angular-site/gwt-angular-web/target/gwt-angular.war site

node sitemap.js
