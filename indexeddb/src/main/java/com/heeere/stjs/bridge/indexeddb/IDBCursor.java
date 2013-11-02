package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.annotation.Template;

public abstract class IDBCursor {
    public abstract IDBRequest update(Object value); // raises (DOMException);
    public abstract void advance(long count); // raises (DOMException);
    @Template("dollardot")
    public abstract void $continue(); //(in optional any key) raises (DOMException);
    @Template("dollardot")
    public abstract void $continue(Object key);
    public abstract IDBRequest delete(); // raises (DOMException);
    
    /**
     * On getting, returns the IDBObjectStore or IDBIndex that the cursor is iterating. This function never returns null or throws an exception, even if the cursor is currently being iterated, has iterated past its end, or its transaction is not active.
     */
    public Object source; 
    /**
     * On getting, returns the direction of traversal of the cursor. See Constants for possible values.
     */
    public String direction;
    /**
     * Returns the key for the record at the cursor's position. If the cursor is outside its range, this is undefined.
     */
    public Object key;
    /**
     * ???
     */
    public Object value;
    /**
     * Returns the cursor's current effective key. If the cursor is currently being iterated or has iterated outside its range, this is undefined.
     */
    public Object primaryKey;
}
