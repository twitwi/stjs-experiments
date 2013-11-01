
package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.Array;

public abstract class IDBObjectStore {

    public abstract IDBRequest add(Object value); // (in any value, in optional any key) raises (DOMException);
    public abstract IDBRequest add(Object value, Object key);
    public abstract IDBRequest clear(); //  raises (DOMException);
    public abstract IDBRequest count(); //(in optional any key) raises(DOMException);
    public abstract IDBRequest count(Object key);
    public abstract IDBIndex createIndex(String name, String keyPath); // (in DOMString name, in DOMString keyPath, in optional IDBIndexParameters optionalParameters) raises (DOMException);
    public abstract IDBIndex createIndex(String name, String keyPath, IDBIndexParameters optionalParameters);
    public abstract IDBRequest delete(Object key); // raises (DOMException);
    public abstract void deleteIndex(String indexName); // (in any DOMString indexName) raises (DOMException);
    public abstract IDBRequest get(Object key); // raises (DOMException);
    public abstract IDBIndex index(String name); // raises (DOMException);
    public abstract IDBRequest openCursor(); // (in optional IDBKeyRange range, in optional unsigned short direction) raises(DOMException);
    public abstract IDBRequest openCursor(IDBKeyRange range);
    public abstract IDBRequest openCursor(IDBKeyRange range, short direction);
    public abstract IDBRequest put(Object value);  // (in any value, in optional any key) raises (DOMException);
    public abstract IDBRequest put(Object value, Object key);

    /**
     * A list of the names of indexes on objects in this object store.
     */
    public Array<String> indexNames; // DOMStringList
    /**
     * The key path of this object store. If this attribute is null, the application must provide a key for each modification operation.
     */
    public String keyPath;
    /**
     * The name of this object store.
     */
    public String name;
    /**
     * The name of the transaction to which this object store belongs.
     */
    public IDBTransaction transaction;
    /**
     * The value of the auto increment flag for this object store.
     */
    public boolean autoIncrement;

}
