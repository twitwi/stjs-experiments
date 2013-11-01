

* add a parent pom
* add the stjs property (version)
* add the stjs dependency

## for a base bridge (no required external library)

* might need to depend on the html bridge
* create a package-info
* ^ annotate it with <tt>@org.stjs.javascript.annotation.STJSBridge</tt>
* create a new class, e.g., GlobalIndexedDB and annotated it with @GlobalScope
* ^ put a static field inside with a new type (create an interface for it, e.g., IndexedDB)
