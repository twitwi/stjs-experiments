package com.heeere.stjs.bridge.indexeddb;

public abstract class IDBKeyRange {
    
    
    public abstract IDBKeyRange bound(Object lower, Object upper); // (in any lower, in any upper, in optional boolean lowerOpen, in optional boolean upperOpen);
    public abstract IDBKeyRange bound(Object lower, Object upper, boolean lowerOpen);
    public abstract IDBKeyRange bound(Object lower, Object upper, boolean lowerOpen, boolean upperOpen);
    public abstract IDBKeyRange only(Object value);
    public abstract IDBKeyRange lowerBound(Object bound); // (in any bound, in optional boolean open);
    public abstract IDBKeyRange lowerBound(Object bound, boolean open);
    public abstract IDBKeyRange upperBound(Object bound); // (in any bound, in optional boolean open);
    public abstract IDBKeyRange upperBound(Object bound, boolean open);
    
    
    /**
     * Lower bound of the key range.
     */
    public Object lower;
    /**
     * Upper bound of the key range.
     */
    public Object upper;
    /**
     * Returns false if the lower-bound value is included in the key range.
     */
    public Object lowerOpen;
    /**
     * Returns false if the upper-bound value is included in the key range.
     */
    public Object upperOpen;
    
}
