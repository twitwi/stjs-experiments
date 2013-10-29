package com.heeere.stjsexpe.experiment1;

import static org.stjs.javascript.Global.*;
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
                alert("Hello onload");
                final Element button = window.document.getElementById("the-button");
                final Input textfield = (Input) window.document.getElementById("the-textfield");
                
                button.onclick = new Function1<DOMEvent, Boolean>() {
                    @Override
                    public Boolean $invoke(DOMEvent p1) {
                        alert("Hello \""+textfield.value+"\"");
                        return true;
                    }
                };
            }
        };
    }
}
