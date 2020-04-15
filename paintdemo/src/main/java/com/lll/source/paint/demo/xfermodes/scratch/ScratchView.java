package com.lll.source.paint.demo.xfermodes.scratch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.lll.source.paint.demo.R;

/**
 * Version 1.0
 * Created by lll on 2020/4/13.
 * Description
 * <pre>
 *     刮刮奖效果
 *
 * </pre>
 * copyright generalray4239@gmail.com
 */
public class ScratchView extends View {

    int mScratchBitmapId;
    String mResultText = "oops, 你的运气就差那么一点点儿哟，加油!!";

    private Paint mTextPaint;
    private Paint mCanvasPaint;
    private Bitmap mScratchBitmap;
    private Bitmap mDestBitmap;
    private Path mPath; //用于绘制手势
    private Rect mTextRect;//文字区域

    private float mEventX, mEventY;
    private float textWidth;
    private float textHeight;

    public ScratchView(Context context, @DrawableRes int scratchBitmapId, String resultText) {
        super(context);
        mScratchBitmapId = scratchBitmapId;
        mResultText = resultText;
        initPaintAndBitmap();
        Log.e("ScratchView", "do init");
    }

    public ScratchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        Log.e("ScratchView", "do 2 init");
    }

    public ScratchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
        Log.e("ScratchView", "do 3 init");
    }

    public ScratchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
        Log.e("ScratchView", "do 4 init");
    }

    private void initView(Context context, @Nullable AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SwitchCompat, 0, 0);
        if (array.hasValue(R.styleable.ScratchView_scratchImgId)) {
            mScratchBitmapId = array.getIndex(R.styleable.ScratchView_scratchImgId);
            Log.e("ScratchView", "the mScratchBitmapId == " + mScratchBitmapId);

        }

        if (array.hasValue(R.styleable.ScratchView_resultText)) {
            mResultText = array.getString(R.styleable.ScratchView_resultText);
            Log.e("ScratchView", "mResultText==" + mResultText);

        }
        array.recycle();
        initPaintAndBitmap();
    }

    private void initPaintAndBitmap() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setAlpha(200);
        mTextPaint.setTextSize(60);
        mTextPaint.setStyle(Paint.Style.FILL);

        mCanvasPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCanvasPaint.setStyle(Paint.Style.FILL);
        mCanvasPaint.setStrokeWidth(4);
        mCanvasPaint.setStrokeCap(Paint.Cap.ROUND);

        mScratchBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eraser);

        //创建一张空白图片，用于显示最终结果
        mDestBitmap = Bitmap.createBitmap(mScratchBitmap.getWidth(), mScratchBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        //定义path
        mPath = new Path();

        mTextRect = new Rect();
        mCanvasPaint.getTextBounds(mResultText, 0, mResultText.length(), mTextRect); //测量文本大小，将文本大小信息存放在rect中
        textWidth = mCanvasPaint.measureText(mResultText); //获取文本的宽
        Paint.FontMetrics metrics = mCanvasPaint.getFontMetrics(); //获取文本的宽
        textHeight = metrics.bottom - metrics.top;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //1、第一步绘制底层文字
//        canvas.drawText(mResultText, mScratchBitmap.getWidth() / 2.0f - textWidth/2.0f , mScratchBitmap.getHeight() / 2.0f - textHeight / 2.0f, mTextPaint);
        canvas.drawText(mResultText, textWidth / 2.0f, mScratchBitmap.getHeight() / 2.0f - textHeight / 2.0f, mTextPaint);


        //2、采用离屏绘制
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), mCanvasPaint, Canvas.ALL_SAVE_FLAG);

        //3、将路径绘制在图片上
        Canvas destCanvas = new Canvas(mDestBitmap);
        destCanvas.drawPath(mPath, mCanvasPaint);

        //4、绘制目标图像
        canvas.drawBitmap(mDestBitmap, 0, 0, mCanvasPaint);
        //设置图片混合模式： PorterDuff.Mode.SRC_OUT 交汇区域清除像素，其余部分显示上层
        mCanvasPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));

        canvas.drawBitmap(mScratchBitmap, 0, 0, mCanvasPaint);

        mCanvasPaint.setXfermode(null);//清除渲染模式
        canvas.restoreToCount(layerId);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mEventX = event.getX();
                mEventY = event.getY();
                mPath.moveTo(mEventX, mEventY);
                break;
            case MotionEvent.ACTION_MOVE:
                float endX = (event.getX() - mEventX) / 2 + mEventX;
                float endY = (event.getY() - mEventY) / 2 + mEventY;
                //画二阶贝塞尔曲线
                mPath.quadTo(mEventX, mEventY, endX, endY);
                mEventX = event.getX();
                mEventY = event.getY();
                break;
        }
        invalidate();//重绘
        return true;
    }
}
