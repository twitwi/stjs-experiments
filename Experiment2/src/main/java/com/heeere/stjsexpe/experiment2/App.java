package com.heeere.stjsexpe.experiment2;

import static org.stjs.javascript.Global.*;
import static com.heeere.stjs.bridge.indexeddb.GlobalIndexedDB.*;
import com.heeere.stjs.bridge.indexeddb.IDBCursor;
import static org.stjs.javascript.JSCollections.*;
import com.heeere.stjs.bridge.indexeddb.IDBDatabase;
import com.heeere.stjs.bridge.indexeddb.IDBObjectStore;
import com.heeere.stjs.bridge.indexeddb.IDBOpenDBRequest;
import com.heeere.stjs.bridge.indexeddb.IDBRequest;
import com.heeere.stjs.bridge.indexeddb.IDBTransaction;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.dom.Input;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function1;


public class App 
{
    public static void main( String[] args ) {
        window.onload = new Callback1<DOMEvent>() {
            @Override
            public void $invoke(DOMEvent p1) {
                final Element save = window.document.getElementById("save");
                final Element read = window.document.getElementById("read");
                final Element container = window.document.getElementById("all");
                final Input textfield = (Input) window.document.getElementById("the-textfield");
                final IDBOpenDBRequest rq = indexedDB.open("teststjsindexeddb3", 1);
                //
                final Function1<DOMEvent, Boolean> onSave = new Function1<DOMEvent, Boolean>() {
                    @Override
                    public Boolean $invoke(DOMEvent p1) {
                        IDBDatabase db = (IDBDatabase) rq.result;
                        IDBTransaction transaction = db.transaction($array("note", "metadata"), "readwrite");
                        IDBObjectStore noteStore = transaction.objectStore("note");
                        noteStore.add(JSCollections.$map(
                                "text", textfield.value,
                                "when", new Date().toTimeString())
                        );
                        transaction.onerror = new Callback1<DOMEvent>() {

                            @Override
                            public void $invoke(DOMEvent p1) {
                                alert("transaction error");
                            }
                        };
                        transaction.oncomplete = new Callback1<DOMEvent>() {

                            @Override
                            public void $invoke(DOMEvent p1) {
                                textfield.value = "Added";
                            }
                        };
                        return true;
                    }
                };
                final Function1<DOMEvent, Boolean> onRead = new Function1<DOMEvent, Boolean>() {
                    @Override
                    public Boolean $invoke(DOMEvent p1) {
                        while (JSObjectAdapter.$js("container.hasChildNodes()")) {
                            container.removeChild(container.lastChild);
                        }
                        IDBDatabase db = (IDBDatabase) rq.result;
                        IDBTransaction transaction = db.transaction($array("note", "metadata"), "readwrite");
                        IDBObjectStore noteStore = transaction.objectStore("note");
                        final IDBRequest cursorRequest = noteStore.openCursor();
                        cursorRequest.onsuccess = new Callback1<DOMEvent>() {

                            @Override
                            public void $invoke(DOMEvent p1) {
                                IDBCursor cursor = (IDBCursor) cursorRequest.result;
                                if (JSObjectAdapter.$js("cursor")) {
                                    Element d = window.document.createElement("div");
                                    d.setAttribute("style", "border: 1px solid black;");
                                    Map v = (Map) cursor.value;
                                    d.innerHTML = cursor.key + "   " + v.$get("when");
                                    container.appendChild(d);
                                    cursor.$continue();
                                }
                            }
                        };
                        return true;
                    }
                };
                //
                
                rq.onupgradeneeded = new Callback1<DOMEvent>() {

                    @Override
                    public void $invoke(DOMEvent p1) {
                        IDBDatabase db = (IDBDatabase) rq.result;
                        db.createObjectStore("note", $map("keyPath", "id", "autoIncrement", true));
                        db.createObjectStore("metadata", $map("keyPath", "id", "autoIncrement", true));
                    }
                };
                rq.onsuccess = new Callback1<DOMEvent>() {

                    @Override
                    public void $invoke(DOMEvent e) {
                        save.onclick = onSave;
                        read.onclick = onRead;
                    }
                };
                
            }
        };
    }
}
