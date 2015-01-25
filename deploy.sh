#!/bin/sh

rm -fr site/*

jar xvf ~/GitHub/gwt-angular-site/gwt-angular-web/target/gwt-angular-web-0.1.3-SNAPSHOT.war site

node sitemap.js
