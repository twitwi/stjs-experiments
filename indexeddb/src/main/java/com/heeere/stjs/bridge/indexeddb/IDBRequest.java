package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.dom.EventTarget;
import org.stjs.javascript.functions.Callback1;

public abstract class IDBRequest implements EventTarget {
    
    public Object result;
    public Object error; // DOMError
    public Object source;
    public IDBTransaction transaction;
    public String readyState;
    public Callback1<DOMEvent> onsuccess;
    public Callback1<DOMEvent> onerror;
    
}
