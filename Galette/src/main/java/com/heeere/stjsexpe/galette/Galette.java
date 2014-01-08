/*
 */

package com.heeere.stjsexpe.galette;

import org.stjs.javascript.Global;
import org.stjs.javascript.dom.Canvas;
import org.stjs.javascript.Math;
import org.stjs.javascript.dom.canvas.CanvasRenderingContext2D;

/**
 *
 * @author @twitwi
 */
public class Galette {
    
    public static int draw(Canvas canvas, int nslices, double _r) {
        CanvasRenderingContext2D ctx = canvas.getContext("2d");
        ctx.save();
        
        int cx = canvas.width / 2;
        int cy = canvas. height / 2;
        int fullR = 200;
        double r = fullR * _r;
        ctx.translate(cx, cy);
        circle(ctx, 0, 0, fullR);
        ctx.fillStyle = "red";
        ctx.fill();
        ctx.lineWidth = 1;
        ctx.strokeStyle = "black";
        ctx.stroke();
        circle(ctx, 0, 0, (int)(fullR - r));
        ctx.fillStyle = "yellow";
        ctx.fill();
        for (int i = 0; i < nslices; i++) {
            from(ctx, 0, 0);
            ctx.lineTo(0, -fullR);
            ctx.stroke();
            // clip only the slice
            ctx.save();
            from(ctx, 0, 0);
            //ctx.lineTo(0, -(int)(fullR - r));
            ctx.arc(0, 0, (fullR - r), -Math.PI/2, 2*Math.PI / nslices - Math.PI/2, false);
            //ctx.lineTo(0, 0);
            ctx.clip();
            // test clip
            circle(ctx, 0, 0, 1000);
            ctx.fillStyle = "rgba(0, "+(i*255/nslices)+", 0, .5)";
            //ctx.fill();
            ctx.beginPath();
            ctx.rect(0, 0, (int)r, -fullR);
            ctx.fill();
            {
                ctx.save();
                ctx.rotate(2*Math.PI / nslices);
                ctx.beginPath();
                ctx.rect(0, 0, -(int)r, -fullR);
                ctx.fill();
                ctx.restore();
            }
            // restore (unclip)
            ctx.restore();
            // special slice (unclipped)
            if (i==0) {
                ctx.save();
                ctx.rotate(2*Math.PI / nslices / 2);
                ctx.translate(0, -(int)(fullR - r - 1));
                ctx.rotate(-2*Math.PI / nslices / 2);
                circle(ctx, 0, 0, (int)r);
                ctx.strokeStyle = "blue";
                ctx.stroke();
                from(ctx, -(int)r, 0); ctx.lineTo((int)r, 0); ctx.stroke();
                from(ctx, 0, -(int)r); ctx.lineTo(0, (int)r); ctx.stroke();
                ctx.restore();
            }
            ctx.rotate(2*Math.PI / nslices);
        }
        ctx.restore();
        return 100;
    }

    private static void circle(CanvasRenderingContext2D ctx, int cx, int cy, int r) {
        ctx.beginPath();
        ctx.arc(cx, cy, r, 0, 2*Math.PI, false);
    }

    private static void from(CanvasRenderingContext2D ctx, int x, int y) {
        ctx.beginPath();
        ctx.moveTo(x, y);
    }

}
