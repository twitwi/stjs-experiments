package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.Array;
import org.stjs.javascript.dom.EventTarget;

public abstract class IDBDatabase implements EventTarget {
    public abstract IDBObjectStore createObjectStore(String name); //, Object optionalParameters) raises (DOMException);)
    public abstract IDBObjectStore createObjectStore(String name, Object optionalParameters);
    public abstract void deleteObjectStore(String name); // raises (DOMException);
    public abstract IDBTransaction transaction(Array<String> storeNames); //, in optional unsigned short mode) raises (DOMException);
    public abstract IDBTransaction transaction(Array<String> storeNames, String optionalMode);
    public abstract void close();
    /**
     * Name of the connected database.
     */
    public String name;
    /**
     * The version of the connected database. When a database is first created, this attribute is the empty string.
     */
    public long version;
    /**
     * A list of the names of the object stores currently in the connected database.
     */
    public Array<String> objectStoreNames; // DOMStringList
}

