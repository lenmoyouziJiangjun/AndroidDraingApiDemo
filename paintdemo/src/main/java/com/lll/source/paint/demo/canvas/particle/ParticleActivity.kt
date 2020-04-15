package com.lll.source.paint.demo.canvas.particle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lll.source.paint.demo.databinding.ActivityParticleBinding

class ParticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityParticleBinding

    lateinit var particleView: ParticleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParticleBinding.inflate(layoutInflater).apply {

            img1.setOnClickListener {
                particleView.startParticleAnimator(it)
            }
            img2.setOnClickListener {
                particleView.startParticleAnimator(it)
            }

            img3.setOnClickListener {
                particleView.startParticleAnimator(it)
            }
            img4.setOnClickListener {
                particleView.startParticleAnimator(it)
            }
            img5.setOnClickListener {
                particleView.startParticleAnimator(it)
            }
            img6.setOnClickListener {
                particleView.startParticleAnimator(it)
            }
        }
        setContentView(binding.root)
        addParticleView()
    }


    private fun addParticleView() {
        particleView =
            ParticleView(this);
        particleView.addToActivityContent(this)
    }
}