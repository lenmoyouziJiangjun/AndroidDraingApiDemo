package com.lll.source.paint.demo.utils;

import android.graphics.Color;
import android.graphics.Paint;

public class PaintUtils {


    public static Paint newTextPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(18);
        paint.setUnderlineText(true);
        return paint;
    }

    public static Paint newTextPaint2() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(18);
        paint.setSubpixelText(true);
        return paint;
    }
}
