package com.heeere.stjs.bridge.indexeddb;

/**
 * Might not be exhaustive?
 * https://developer.mozilla.org/en-US/docs/Web/API/IDBObjectStore?redirectlocale=en-US&redirectslug=IndexedDB%2FIDBObjectStore
 */
public abstract class IDBIndexParameters {
    
    /**
     * If true, the index will not allow duplicate values for a single key.
     */
    public boolean unique;
    /**
     * If true, the index will add an entry in the index for each array element when the keypath resolves to an Array. If false, it will add one single entry containing the Array.
     */
    public boolean multiEntry;
    
}
