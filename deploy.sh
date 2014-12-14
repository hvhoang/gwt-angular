#!/bin/sh

rm -fr site/*

jar xvf ~/GitHub/gwt-angular-site/gwt-angular-web/target/gwt-angular.war site

node sitemap.js
