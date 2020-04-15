package com.lll.source.paint.demo.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.lll.source.paint.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Version 1.0
 * Created by lll on 2020/4/15.
 * Description
 *
 * <pre>
 *  矩阵matrix 为一个3*3的矩阵。
 * {
 *     {MSCALE_X, MSKEW_X, MTRANS_X},
 *
 *     {MSKEW_Y, MSCALE_Y, MTRANS_Y},
 *
 *     {MPERSP_0, MPERSP_1, MPERSP_2},
 * }
 *
 * 1、分为4个操作：scale、skew、translate、 persp透视
 *
 * 2、每一个操作又分为：前乘pre[matrix在前面] 和后乘post[matrix在后面] 两种情况
 *
 * 3、屏幕上显示的像素点为一个三行一列的矩阵
 *   {
 *    {x}
 *    {y}
 *    {z=1默认为1，大于1，屏幕拉远，图形变小}
 *   }
 * </pre>
 * <p>
 * copyright generalray4239@gmail.com
 */
public class MatrixApiView extends View {

    private List<Matrix> matrixList;

    private Bitmap bitmap;

    private Matrix mMatrix;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int matrixIndex = 0;

    public MatrixApiView(Context context) {
        super(context);
        init();
    }

    public MatrixApiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixApiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
        matrixList = new ArrayList<>(10);
        matrixList.add(MatrixUtils.newTransMatrix(bitmap.getWidth(), bitmap.getHeight()));
        matrixList.add(MatrixUtils.newRotateMatrix(bitmap.getWidth(), bitmap.getHeight()));
        matrixList.add(MatrixUtils.newRotateAndTranslateMatrix(bitmap.getWidth(), bitmap.getHeight()));
        matrixList.add(MatrixUtils.newScaleMatrix());
        matrixList.add(MatrixUtils.newSkewY());
        matrixList.add(MatrixUtils.newSkewXY());
        matrixList.add(MatrixUtils.newSymmetryY(bitmap.getWidth()));
        matrixList.add(MatrixUtils.netSymmetryXY(bitmap.getWidth(), bitmap.getHeight()));
        mMatrix = matrixList.get(matrixIndex);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制原生图片
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        canvas.save();
        canvas.translate(200f, 200f);
        //绘制变换图片
        canvas.drawBitmap(bitmap, mMatrix, mPaint);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (matrixIndex == matrixList.size() - 1) {
                matrixIndex = 0;
            } else {
                matrixIndex += 1;
            }
            mMatrix = matrixList.get(matrixIndex);
            MatrixUtils.printMatrix(mMatrix);
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
