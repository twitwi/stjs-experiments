package com.heeere.stjsexpe.galette;

import org.stjs.javascript.Global;
import static org.stjs.javascript.Global.*;
import org.stjs.javascript.dom.Canvas;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.dom.Input;
import org.stjs.javascript.functions.Callback1;

/**
 */
public class App {
    public static void main( String[] args ) {
        window.onload = new Callback1<DOMEvent>() {

            @Override
            public void $invoke(DOMEvent p1) {
                final Canvas canvas = (Canvas) Global.window.document.getElementById("draw");
                final Input slices = (Input) Global.window.document.getElementById("slices");
                final Input r = (Input) Global.window.document.getElementById("r");
                Galette.draw(canvas, parseInt(slices.value), parseFloat(r.value));
                Callback1<DOMEvent> redraw = new Callback1<DOMEvent>() {
                    @Override
                    public void $invoke(DOMEvent p1) {
                        Galette.draw(canvas, parseInt(slices.value), parseFloat(r.value));
                    }
                };
                slices.addEventListener("input", redraw);
                r.addEventListener("input", redraw);
            }
        };
    }
}
