package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.dom.EventTarget;
import org.stjs.javascript.functions.Callback1;

public abstract class IDBTransaction implements EventTarget {
    
    public abstract void abort(); // raises (DOMException);
    public abstract IDBObjectStore objectStore(String name); // raises (DOMException);
    
    public IDBDatabase db;
    public String mode;
    public Object error; // DOMError
    public Callback1<DOMEvent> onabort;
    public Callback1<DOMEvent> oncomplete;
    public Callback1<DOMEvent> onerror;

}
