package com.heeere.stjsexpe.experiment1;

import static org.stjs.javascript.Global.*;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.functions.Callback1;


public class App 
{
    public static void main( String[] args ) {
        window.onload = new Callback1<DOMEvent>() {
            @Override
            public void $invoke(DOMEvent p1) {
                alert("Test");
            }
        };
    }
}
