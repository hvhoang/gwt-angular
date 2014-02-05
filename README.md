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

Version 0.0.0 development will take place in master branch. During this time,
none of the interfaces are frozen. When the release version of 0.0.0 is created,
the development of 0.1.0 will start in develop branch. Any patches to 0.0.0
will be indicated by the patch number (i.e. the third number in version number
sequence). Only additive changes to the programming interface may be introduced
when patching. On the other hand, while the major version number is 0, every
minor version upgrade may introduce programming interface changes that could
make the new version incompatible with the earlier version.

For example,

0.0.0 user is able to drop in 0.0.1 without any programming interface changes.
Note, however, that the user may still need to modify their code to deal with
"side effects" of the code even though the interface has not changed.

0.1.0 user is able to drop in 0.1.1 (as above).

0.1.1 user will not be able to drop in 0.2.0, because the programming interface
may have changed between 0.1.x to 0.2.x.

This convention will be observed until 1.0.0 is reached. From that point on,
none of the minor version upgrade will destroy the programming interface, i.e.

1.0.0 user will be able to drop in 1.0.1 (as above).
1.1.0 user will be able to drop in 1.1.1 (as above).
1.0.0 user will be able to drop in 1.2.0 (as above).
1.2.0 user will not be able to drop in 2.0.0 due to interface changes.

TODO
====
* Abstract module dependency support so modules are not mentioned by name
* Refactor controller construction, retire Constructable interface
* Clean up Deferred interface
* Get HTTP working, and possibly move it out to separate module