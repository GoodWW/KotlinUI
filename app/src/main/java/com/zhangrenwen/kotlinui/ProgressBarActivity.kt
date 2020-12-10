package com.zhangrenwen.kotlinui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zhangrenwen.kotlinui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_progress_bar.*

class ProgressBarActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
    }

    fun barClick(view: View) {
        if (progressBar.visibility == View.VISIBLE) {
            progressBar.visibility = View.GONE
            Toast.makeText(this, "" + View.GONE, Toast.LENGTH_SHORT).show()
        } else {
            progressBar.visibility = View.VISIBLE
            Toast.makeText(this, "" + View.VISIBLE, Toast.LENGTH_SHORT).show()
        }
    }

    fun barClick1(view: View) {
        if (progressBar1.progress >= 100) {
            progressBar1.progress = 0
        }
        progressBar1.progress = progressBar1.progress + 10
    }
}