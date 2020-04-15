package com.lll.source.paint.demo.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;

import static android.util.TypedValue.COMPLEX_UNIT_PX;

public class Utils {

    private Utils() {
    }

    private static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;

    public static float dp2Px(int dp) {
        return TypedValue.applyDimension(COMPLEX_UNIT_PX, dp, Resources.getSystem().getDisplayMetrics());
    }


    /**
     * @param view
     * @return
     */
    public static Bitmap createBitmapFromView(View view) {
        if (null == view) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
