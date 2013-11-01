package com.heeere.stjs.bridge.indexeddb;

import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.functions.Callback1;

public abstract class IDBOpenDBRequest extends IDBRequest {
    
    public Callback1<DOMEvent> onblocked;
    public Callback1<DOMEvent> onupgradeneeded;

}
