Introduction
============

#### Live Demo URL --> http://kyoken74.github.io/gwt-angular/
The demo application gwt-angular-site demonstrates the usage of gwt-angular
API in a live application (documentation).

The demo application uses Twitter's [Bootstrap](http://getbootstrap.com) as
the view framework.

### WARNING
The API is in very early stages of development, and it is not yet ready for
beta.


Collaborators Wanted
====================
Although I have many years of Java and GWT development experience, my 
understanding of AngularJS is naïve at best. If any AngularJS experts out 
there who can help me understand the core design philosophy of this powerful 
framework, please let me know. I can use your help.

You may have figured out that this is a one-man project started in his 
kitchen (I do not have a garage). There is no corporate sponsor behind this 
project.


Getting Started
===============

### Building the project
Set up [Maven](http://maven.apache.org) on your machine, and then execute 
the following commands to build the project.
```
git clone https://github.com/kyoken74/gwt-angular.git
cd gwt-angular
mvn clean install
```

### Running the Live Demo
gwt-angular-site contains the source code for our Live Demo site.

If you have a JEE container, you can simply deploy the following WAR 
artifact to your server after building the project.
```
gwt-angular/gwt-angular-site/gwt-angular-web/gwt-angular.war
```

If you have a web server, you can expand the above WAR file, and deploy the
extracted code to your web server's htdocs area. You can discard the 
META-INF and WEB-INF directories, because they are only relevant to JEE 
containers.
```
gwt-angular.war
	/site
	/index.html
	/sitemap.xml
```

If you plan to run the site for development, please note that only 
SuperDevMode is supported. HostedMode (DevMode) is not supported. You can 
set up the SuperDevMode for gwt-angular-web project.

Main Class
	com.google.gwt.dev.codeserver.CodeServer

Main Argument
	-src src/test/java com.asayama.gwt.angular.site.SuperDevMode

Required JAR
	gwt-codeserver.jar


Overview
========
The purpose of gwt-angular project is to bring the powerful MVC framework of
AngularJS to Java programmers.

gwt-angular provides a GWT wrapper around AngularJS, so that the controller
component of AngularJS can be written in Java language, in a manner that is 
natural to a programmer with little background in JavaScript but with
more experience in Java. gwt-angular aims to bridge the gap in paradigm.

The purpose of gwt-angular is to introduce a clear separation between the 
view and controller for GWT developers, which has been a challenge. The 
views are intended to be written in HTML/CSS, and, as such, gwt-angular does 
not provide any view components (i.e. widgets) in Java. The users are  
encouraged to explorer various HTML based view frameworks.

- [GWT](http://www.gwtproject.org)
- [AngularJS](http://angularjs.org/)

*Note that while gwt-angular project uses the products provided by above 
projects, gwt-angular itself is not affiliated with the above projects.*
