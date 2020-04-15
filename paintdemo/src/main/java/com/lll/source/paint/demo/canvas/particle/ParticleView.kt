package com.lll.source.paint.demo.canvas.particle

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AccelerateInterpolator
import com.lll.source.paint.demo.utils.Utils

/**
 * Version 1.0
 * Created by lll on 2020/4/14.
 * Description
 * <pre>
 *
 *   图片碎掉效果
 * <pre>
 * copyright generalray4239@gmail.com
 */
class ParticleView(context: Context) : View(context) {

    private val startDelay: Long = 150

    /**
     *
     */
    private val particleAnimatorList: MutableList<ParticleAnimator> = mutableListOf()


    /**
     *
     *
     */
    fun addToActivityContent(activity: Activity) {
        val contentView = activity.findViewById<ViewGroup>(Window.ID_ANDROID_CONTENT)
        contentView.addView(
            this, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }


    fun startParticleAnimator(anchorView: View) {
        val visibleRect = Rect()
        val location = IntArray(2)
        getLocationOnScreen(location)
        visibleRect.offset(-location[0], -location[1]);
        visibleRect.inset(-Utils.dp2Px(32).toInt(), -Utils.dp2Px(32).toInt())

        anchorView.getGlobalVisibleRect(visibleRect)
        val bitmap = Utils.createBitmapFromView(anchorView)
        val animator = ParticleAnimator(
            this,
            bitmap,
            visibleRect
        ).apply {
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animator: Animator) {
                    particleAnimatorList.remove(animator)
                }
            })
            setFloatValues(0f, 1.4f)
            startDelay = startDelay
            duration = 400
            interpolator = AccelerateInterpolator(0.6f)
        }

        particleAnimatorList.add(animator)
        animator.start()

        //hideView
        anchorView.animate().setDuration(150).setStartDelay(startDelay).scaleX(0f).scaleY(0f)
            .alpha(0f).start()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (p in particleAnimatorList) {
            p.drawParticle(canvas)
        }
    }

}