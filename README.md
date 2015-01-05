Live Demo
=========

|http://gwt-angular.asayama.com/|
---------------------------------

### WARNING

The API is in very early stages of development, and it is not yet ready for beta.

|Version|Projected Stability|
|-------|-------------------|
| 0.0.x |The interface is still volatile. From build to build, any interfaces may be removed without any prior notice. |
| 0.1.x | The public interface is frozen. Deprecated interfaces will be annotated prior to removal in v0.2. |
| 0.x.x |Any subsequent releases with minor version (the second numeral) increase indicate that the interfaces previously deprecated may be removed. |
| 1.0.0-alpha.x | The API will become available for early preview. |
| 1.0.0-beta.x  | The API will become available for beta testing. |


Collaborators Wanted
====================
Although I have many years of Java and GWT development experience, my understanding of AngularJS is naïve at best. If any AngularJS experts out there who can help me understand the core design philosophy of this powerful framework, please let me know. I can use your help.

You may have figured out that this is a one-man project started in his kitchen (I do not have a garage). There is no corporate sponsor behind this project.


Getting Started
===============

### Building the project
You will need the following build and package management tools to build GWT Angular project.

* [npm](https://www.npmjs.com/)
* [bower](http://bower.io)
* jdk
* [maven](http://maven.apache.org)

Install bower if you have not done so yet.

```
npm install -g bower
```

If you are running the above command from a restricted account, and, if you do have access to privileged account, you may have to execute the above command using `sudo`.

Set up maven on your machine, and then execute the following commands to build the project.

```
git clone https://github.com/kyoken74/gwt-angular.git
cd gwt-angular
mvn clean install
```

Overview
========
The purpose of gwt-angular project is to bring the powerful MVC framework of AngularJS to Java programmers.

gwt-angular provides a GWT wrapper around AngularJS, so that the controller component of AngularJS can be written in Java language, in a manner that is natural to a programmer with little background in JavaScript but with more experience in Java. gwt-angular aims to bridge the gap in paradigm.

The purpose of gwt-angular is to introduce a clear separation between the view and controller for GWT developers, which has been a challenge. The views are intended to be written in HTML/CSS, and, as such, gwt-angular does not provide any view components (i.e. widgets) in Java. The users are encouraged to explorer various HTML based view frameworks.

- [GWT](http://www.gwtproject.org)
- [AngularJS](http://angularjs.org/)

*Note that while gwt-angular project uses the products provided by above projects, gwt-angular itself is not affiliated with the above projects.*


Thanks
======
I'd like to thank the following entities and individuals.

- GitHub for Hosting the GIT repository
- Sonatype for Hosting the binary artifacts
- Javadoc.io for Hosting the javadoc
- Eyal Shaked for reporting build issues
