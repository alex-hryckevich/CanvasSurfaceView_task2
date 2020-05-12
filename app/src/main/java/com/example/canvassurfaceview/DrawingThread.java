package com.example.canvassurfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.SurfaceHolder;

public class DrawingThread extends Thread {
    SurfaceHolder surfaceHolder;

    public DrawingThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        Canvas canvas = surfaceHolder.lockCanvas();
        if(canvas != null){
            //rectangle
            canvas.drawRGB(0,0,200);
            canvas.drawRoundRect(new RectF(200,200,350,350), 0, 0, new Paint(Paint.ANTI_ALIAS_FLAG));

            //triangle
            Path path = new Path();
            path.moveTo(400,10);
            path.lineTo(600,60);
            path.lineTo(500,900);
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStyle(Paint.Style.FILL);
            p.setARGB(255,255,20,147);
            canvas.drawPath(path,p);

            //circle
            path.reset();
            path.addCircle(100,500,50, Path.Direction.CW);
            p.setARGB(255,148,0,211);
            canvas.drawPath(path,p);

            //text
            p.setARGB(255,143, 254, 9);
            p.setTextSize(90);
            canvas.drawText("Second task is done", 250, 1500, p);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}