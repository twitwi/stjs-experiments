

* add a parent pom
* add the stjs property (version)
* add the stjs dependency

## for a base bridge (no required external library)

* might need to depend on the html bridge
* create a package-info
* ^ annotate it with <tt>@org.stjs.javascript.annotation.STJSBridge</tt>
* create a new class, e.g., GlobalIndexedDB and annotated it with @GlobalScope
* ^ put a static field inside with a new type (create an interface for it, e.g., IndexedDB)
* creates the interfaces and methods for the js lib
* ^ create abstract classes when you need to put attributes inside (and hope that there is no multiple inheritance used in the js api)
* ^ use MDN to know the API and structures
* ^ reuse existing stuff like dom.EventTarget
* ^ when it seems very complicated (e.g., DOMError not implemented) put Object
* ^ an event handler is of type <tt>Callback1&lt;DOMEvent></tt>
* ^ DOMStringList is as <tt>Array&lt;String></tt> (not sure)
* ^ MDN is not fully correct... adapt it
