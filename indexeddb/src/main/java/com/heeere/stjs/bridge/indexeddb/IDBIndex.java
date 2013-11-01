package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.dom.EventTarget;

public abstract class IDBIndex implements EventTarget {
    
    public abstract IDBRequest get(Object key); // (in any key) raises (DOMException);
    public abstract IDBRequest getKey(Object key); // (in any key) raises (DOMException);
    public abstract IDBRequest count(); // (in optional any key) raises (DOMException);
    public abstract IDBRequest count(Object key);
    public abstract IDBRequest openCursor(); // (in any ? range, in optional unsigned short direction) raises (DOMException);
    public abstract IDBRequest openCursor(IDBKeyRange range);
    public abstract IDBRequest openCursor(IDBKeyRange range, short direction);
    public abstract IDBRequest openKeyCursor(); // (in any ? range, in optional unsigned short direction) raises(DOMException);
    public abstract IDBRequest openKeyCursor(IDBKeyRange range);
    public abstract IDBRequest openKeyCursor(IDBKeyRange range, short direction);
    
    /**
     * The name of this index.
     */
    public String name;
    /**
     * The name of the object store referenced by this index.
     */
    public IDBObjectStore objectStore;
    /**
     * The key path of this index. If null, this index is not auto-populated.
     */
    public String keyPath;
    /**
     * Affects how the index behaves when the result of evaluating the index's key path yields an array. If true, there is one record in the index for each item in an array of keys. If false, then there is one record for each key that is an array.
     */
    public boolean multiEntry;
    /**
     * If true, this index does not allow duplicate values for a key.
     */
    public boolean unique;
}
