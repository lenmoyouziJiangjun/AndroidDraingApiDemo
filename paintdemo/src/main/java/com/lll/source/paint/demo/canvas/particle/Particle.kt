package com.lll.source.paint.demo.canvas.particle

data class Particle(
    var color: Int, //图片像素点颜色值
    var x: Float, //粒子圆心坐标x
    var y: Float,//粒子圆心坐标y
    var r: Float, //粒子半径
    var alpha: Float = 1f,//透明度


    var vX: Float, //粒子运动水平方向速度
    var vY: Float, //粒子运动垂直方向速度
    var aX: Float, //粒子运动水平方向加速度
    var aY: Float //粒子运动垂直方向加速度
) {


    fun updateValue(interValue: Float) {
        alpha -= interValue
        x += vX
        y += vY
        vX += aX
        vY += aY
    }
}