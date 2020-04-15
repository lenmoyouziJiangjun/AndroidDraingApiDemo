package com.lll.source.paint.demo.canvas.splash

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lll.source.paint.demo.PaintDemoActivity

/**
 * Version 1.0
 * Created by lll on 2020/4/15.
 * Description
 * copyright generalray4239@gmail.com
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SplashView(this))
    }


    override fun onResume() {
        super.onResume()
        Handler().postDelayed(Runnable {
            val intent = Intent(this@SplashActivity, PaintDemoActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            finish()
        }, 5600)

    }
}