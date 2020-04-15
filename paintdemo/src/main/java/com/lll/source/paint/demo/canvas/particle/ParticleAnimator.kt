package com.lll.source.paint.demo.canvas.particle

import android.animation.ValueAnimator
import android.graphics.*
import android.util.Log
import android.view.View
import java.util.*
import kotlin.math.ceil


class ParticleAnimator(
    private val container: View,
    private val bitmap: Bitmap,
    private val visibleRect: Rect
) :
    ValueAnimator() {

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val particleDiameter: Int = 16 //粒子直径

    private val random: Random = Random()

    private val particleList: MutableList<Particle> = mutableListOf<Particle>()


    init {
        generatorParticle()

    }


    private fun generatorParticle() {
        val width: Int = visibleRect.width()
        val height: Int = visibleRect.height()
        Log.e("ParticleAnimator", "width ===$width, height ==$width")
        for (i in 0 until width step 10) {
            for (j in 0 until height step 10) {

                val particle =
                    Particle(
                        color = bitmap.getPixel(i, j),
                        x = visibleRect.left + (i - particleDiameter / 2).toFloat(),
                        y = visibleRect.top + (j - particleDiameter / 2).toFloat(),
                        r = (particleDiameter / 2).toFloat(),
                        //x 方向的运动速度范围(-20,20)
                        vX = (Math.pow(
                            -1.0,
                            Math.ceil(Math.random() * 1000)
                        ) * 20 * Math.random()).toFloat(),

                        //y方向运动速度
                        vY = getVY(-15, 35),
                        aX = 0.1F, //x方向加速度
                        aY = 0.98F //y方向加速度
                    )

                Log.e(
                    "ParticleAnimator",
                    "i ===$i, j ==$j, x===${visibleRect.left}, y === ${visibleRect.top},centerX==${visibleRect.centerX()}, centerY=${visibleRect.centerY()}" +
                            "px===${particle.x}" +
                            ",py===${particle.y}"
                )
                particleList.add(particle)
            }
        }
    }

    private fun getVY(min: Int, max: Int): Float {

        //在0到(max - min)范围内变化，取大于x的最小整数 再随机
        //在0到(max - min)范围内变化，取大于x的最小整数 再随机
        return (min + ceil(Math.random() * (max - min))).toFloat()
    }


    override fun start() {
        super.start()
        container.invalidate(visibleRect)
    }


    fun drawParticle(canvas: Canvas): Boolean {
        if (!isStarted) {
            return false
        }
        for (particle in particleList) {
            particle.updateValue(animatedValue as Float)
            paint.color = particle.color
            paint.alpha = (255 * particle.alpha).toInt()
            canvas.drawCircle(particle.x, particle.y, particle.r, paint)
        }
        container.invalidate()
        return true
    }


}