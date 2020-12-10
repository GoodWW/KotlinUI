package com.zhangrenwen.kotlinui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun progressBarClick(view: View) {
        startActivity(Intent(this, ProgressBarActivity::class.java))
    }
}