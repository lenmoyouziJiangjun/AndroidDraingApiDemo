package com.lll.source.paint.demo.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class BitmapUtils {

    /**
     * 生成特殊效果的头像
     *
     * @param header
     * @param coverBitmap
     * @return
     */
    public static Bitmap createHeader(Bitmap header, Bitmap coverBitmap) {
        Canvas canvas = new Canvas();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(coverBitmap, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(header, 0, 0, paint);

        paint.setXfermode(null);

        return coverBitmap;
    }


    /**
     * Given an input bitmap, scales it to the given width/height and makes it round.
     *
     * @param input        {@link Bitmap} to scale and crop
     * @param targetWidth  desired output width
     * @param targetHeight desired output height
     * @return output bitmap scaled to the target width/height and cropped to an oval. The
     * cropping algorithm will try to fit as much of the input into the output as possible,
     * while preserving the target width/height ratio.
     */
    public static Bitmap getRoundedBitmap(Bitmap input, int targetWidth, int targetHeight) {
        if (input == null) {
            return null;
        }
        final Bitmap.Config inputConfig = input.getConfig();
        final Bitmap result = Bitmap.createBitmap(targetWidth, targetHeight,
                inputConfig != null ? inputConfig : Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(result);
        final Paint paint = new Paint();
        canvas.drawARGB(0, 0, 0, 0);
        paint.setAntiAlias(true);
        final RectF dst = new RectF(0, 0, targetWidth, targetHeight);
        canvas.drawOval(dst, paint);

        // Specifies that only pixels present in the destination (i.e. the drawn oval) should
        // be overwritten with pixels from the input bitmap.
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        final int inputWidth = input.getWidth();
        final int inputHeight = input.getHeight();

        // Choose the largest scale factor that will fit inside the dimensions of the
        // input bitmap.
        final float scaleBy = Math.min((float) inputWidth / targetWidth,
                (float) inputHeight / targetHeight);

        final int xCropAmountHalved = (int) (scaleBy * targetWidth / 2);
        final int yCropAmountHalved = (int) (scaleBy * targetHeight / 2);

        final Rect src = new Rect(
                inputWidth / 2 - xCropAmountHalved,
                inputHeight / 2 - yCropAmountHalved,
                inputWidth / 2 + xCropAmountHalved,
                inputHeight / 2 + yCropAmountHalved);

        canvas.drawBitmap(input, src, dst, paint);
        return result;
    }




}
