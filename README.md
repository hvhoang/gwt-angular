WARNING
=======

The API is in very early stages of development, and it is not yet ready for
beta.


gwt-angular
===========

The purpose of gwt-angular project is to bring the powerful MVC framework of
AngularJS to Java programmers.

gwt-angular provides a GWT wrapper around AngularJS, so that the controller
component of AngularJS can be written in Java language, in a manner that is 
more natural to a programmer with little background in JavaScript but come with
more experience in Java.

The purpose of gwt-angular is to introduce a clear separation between the view
and controller. The views are intended to be written in HTML/CSS, and, as such,
gwt-angular does not provide any view components (i.e. widgets) in Java. The 
users are  encouraged to explorer various HTML based view frameworks. (The demo
application gwt-angular-demo uses Twitter's Bootstrap.)

GWT
	http://www.gwtproject.org

AngularJS
	http://angularjs.org/

Bootstrap
	http://getbootstrap.com


Versioning
==========

0.0.x development will continue in develop branch, and with every release, we
will increment the patch number. The programming interface will remain unstable
during this cycle.

The interface will become stable once we reach 1.0.0. From this point, only
additive changes will be introduced to the programming interface, so that the
users can upgrade to the new versions without major code changes.

The users should be aware, however, that the side effects may change without
notice even when the interface remains unchanged. This may require code changes
when upgrading to later versions.

1.0.0 user will be able to drop in 1.0.1
1.1.0 user will be able to drop in 1.1.1
1.0.0 user will be able to drop in 1.2.0
1.2.0 user will not be able to drop in 2.0.0 due to interface changes.

When the major versions are changed, the previously deprecated interfaces may
be removed; hecne requiring code changes to those users relying on the old 
interface.

TODO
====
* Abstract module dependency support so modules are not mentioned by name
* Refactor controller construction, retire Constructable interface
* Clean up Deferred interface
* Get HTTP working, and possibly move it out to separate module
* Robustness and error reporting