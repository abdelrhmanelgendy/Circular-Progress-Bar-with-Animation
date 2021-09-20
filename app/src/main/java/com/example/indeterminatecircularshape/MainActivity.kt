package com.example.indeterminatecircularshape

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var txtProgress: TextView
    lateinit var btnStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.mainActivity_circularProgressBar)
        txtProgress = findViewById(R.id.mainActivity_textProgress)
        btnStart = findViewById(R.id.mainActivity_btnStart)
        btnStart.setOnClickListener { startProgressBarAnimation() }

    }

    private fun startProgressBarAnimation() {
        val progress = 70
        progressBar.max = 100
        progressBar.progress = 0

        val progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0, progress)
        progressAnimator.setDuration(2000)
        progressAnimator.start()
        progressAnimator.addUpdateListener { animationUpate ->
            val inProgressValue = animationUpate?.getAnimatedValue() as Int
            txtProgress.setText(inProgressValue.toString() + "%")
        }

    }


}
