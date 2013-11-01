package com.heeere.stjs.bridge.indexeddb;

public interface IDBFactory {
    
    public IDBOpenDBRequest open(String name, long version);
    public IDBOpenDBRequest deleteDatabase(String name);
    
    /**
     * ((from MDN))
     * Compares two values as keys to determine equality and ordering for IndexedDB operations, such as storing and iterating. Do not use this method for comparing arbitrary JavaScript values, because many JavaScript values are either not valid IndexedDB keys (booleans and objects, for example) or are treated as equivalent IndexedDB keys (for example, since IndexedDB ignores arrays with non-numeric properties and treats them as empty arrays, so any non-numeric arrays are treated as equivalent). This throws an exception if either of the values is not a valid key.
     * @return -1, 0, 1
     */
    public int cmp(Object first, Object second);
    
}
