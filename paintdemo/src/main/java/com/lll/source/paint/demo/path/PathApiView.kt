package com.lll.source.paint.demo.path

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PathApiView : View {

    private val paint: Paint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }

    private val path: Path by lazy {
        Path()
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //一阶贝塞尔曲线，表示的是一条直线
        path.moveTo(100f, 70f)
        path.lineTo(1400f, 2000f) //连线
//        path.close();//设置曲线是否闭合




        //添加子图形addXXX
        //添加弧形
        //        path.lineTo(250, 600);
////        path.close();//设置曲线是否闭合

        //添加子图形addXXX
        //添加弧形
        path.addArc(200f, 200f, 400f, 400f, -225f, 225f)

////
//        //Path.Direction.CW表示顺时针方向绘制，CCW表示逆时针方向
//        //
//        //Path.Direction.CW表示顺时针方向绘制，CCW表示逆时针方向

        path.addRect(500f, 500f, 900f, 900f, Path.Direction.CW)


//        //添加一个圆
//        //添加一个圆
//        path.addCircle(700f, 700f, 200f, Path.Direction.CW)
//        //添加一个椭圆
//        //添加一个椭圆
//        path.addOval(0f, 0f, 500f, 300f, Path.Direction.CCW)
//
//        //追加图形
//        //xxxTo画线
//
//        //追加图形
//        //xxxTo画线
//        path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
////
//        //forceMoveTo，true，绘制时移动起点，false，绘制时连接最后一个点与圆弧起点
//        //
//        //forceMoveTo，true，绘制时移动起点，false，绘制时连接最后一个点与圆弧起点
//        path.moveTo(0f, 0f)
//        path.lineTo(100f, 100f)
//        path.arcTo(400f, 200f, 600f, 400f, 0f, 270f, false)
//
//        //添加一个路径
//
//        //添加一个路径
        path.moveTo(100f, 70f)
        path.lineTo(140f, 180f)
        path.lineTo(250f, 330f)
        path.lineTo(400f, 630f)
        path.lineTo(100f, 830f)

        val newPath = Path()
        newPath.moveTo(100f, 1000f)
        newPath.lineTo(600f, 1300f)
        newPath.lineTo(400f, 1700f)
        path.addPath(newPath)
        path.close()
//
//        //添加圆角矩形， CW顺时针，CCW逆时针
//
        //添加圆角矩形， CW顺时针，CCW逆时针
        val rectF5 = RectF(200f, 800f, 700f, 1200f)
        path.addRoundRect(rectF5, 20f, 20f, Path.Direction.CCW)

//
//        //画二阶贝塞尔曲线
        path.moveTo(300f, 500f)
//        path.quadTo(500, 100, 800, 500);
        //参数表示相对位置，等同于上面一行代码
        //        path.quadTo(500, 100, 800, 500);
        //参数表示相对位置，等同于上面一行代码
        path.rQuadTo(200f, -400f, 500f, 0f)
////
////
//        //画三阶贝塞尔曲线
//        //
////
//        //画三阶贝塞尔曲线
        path.moveTo(300f, 500f)
//        path.cubicTo(500, 100, 600, 1200, 800, 500);
        //参数表示相对位置，等同于上面一行代码
        //        path.cubicTo(500, 100, 600, 1200, 800, 500);
        //参数表示相对位置，等同于上面一行代码
        path.rCubicTo(200f, -400f, 300f, 700f, 500f, 0f)
//
//
        canvas.drawPath(path, paint)
    }

}