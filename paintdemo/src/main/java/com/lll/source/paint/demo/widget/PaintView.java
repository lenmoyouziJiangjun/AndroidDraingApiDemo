package com.lll.source.paint.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

/**
 * Version 1.0
 * Created by lll on 2020/4/13.
 * Description
 * <pre>
 *
 *
 * </pre>
 * copyright generalray4239@gmail.com
 */
public class PaintView extends View {

    private Paint mPaint;
    private String mDrawText;


    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initWidget(@NotNull Paint paint, @NotNull String text) {
        mPaint = paint;
        mDrawText = text;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(mDrawText) && mPaint != null) {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
            canvas.drawText(mDrawText, 12, 12, mPaint);
        }
    }
}
