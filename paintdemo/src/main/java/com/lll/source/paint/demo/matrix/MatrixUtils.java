package com.lll.source.paint.demo.matrix;

import android.graphics.Matrix;
import android.util.Log;

public class MatrixUtils {

    private MatrixUtils() {
    }

    /**
     * 平移
     *
     * @param width
     * @param height
     * @return
     */
    public static Matrix newTransMatrix(int width, int height) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(width, height);
        return matrix;
    }

    /**
     * 旋转
     *
     * @param width
     * @param height
     * @return
     */
    public static Matrix newRotateMatrix(int width, int height) {
        Matrix matrix = new Matrix();
        matrix.postRotate(45f, width / 2, height / 2);
        matrix.postTranslate(width, height);
        return matrix;
    }

    /**
     * 平移旋转
     * @param width
     * @param height
     * @return
     */
    public static Matrix newRotateAndTranslateMatrix(int width, int height) {
        Matrix matrix = new Matrix();
        matrix.setRotate(45f);
        matrix.preTranslate(-width, -height);
        matrix.postTranslate(width, height);
        return matrix;
    }


    /**
     * 缩放
     *
     * @return
     */
    public static Matrix newScaleMatrix() {
        Matrix matrix = new Matrix();
        matrix.setScale(0f, 0.5f);
        return matrix;
    }

    /**
     * 垂直倾斜
     *
     * @return
     */
    public static Matrix newSkewY() {
        Matrix matrix = new Matrix();
        matrix.setSkew(0f, 0.5f);
        return matrix;
    }

    /**
     * 水平且垂直倾斜
     *
     * @return
     */
    public static Matrix newSkewXY() {
        Matrix matrix = new Matrix();
        matrix.setSkew(0.5f, 0.5f);
        return matrix;
    }

    /**
     * 图片关于Y轴对称
     *
     * @param width
     * @return
     */
    public static Matrix newSymmetryY(int width) {
        Matrix matrix = new Matrix();
        float matrixValues[] = {-1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrixValues);
        //若是matrix.postTranslate(width,0);
        //表示将图片左右倒置
        matrix.postTranslate(width * 2, 0);
        return matrix;
    }

    /**
     * 图片关于对角线对称
     *
     * @param width
     * @param height
     * @return
     */
    public static Matrix netSymmetryXY(int width, int height) {
        Matrix matrix = new Matrix();
        float matrixValues[] = {0f, -1f, 0f, -1f, 0f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrixValues);
        matrix.postTranslate(width + height, width + height);
        return matrix;
    }


    public static void printMatrix(Matrix matrix) {
        float matrixValues[] = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; i++) {
            String valueString = "";
            for (int j = 0; j < 3; j++) {
                valueString = matrixValues[3 * i + j] + "";
                Log.e("MatrixUtils", "第" + (i + 1) + "行的第" + (j + 1) + "列的值为" + valueString);
            }
        }
    }
}
