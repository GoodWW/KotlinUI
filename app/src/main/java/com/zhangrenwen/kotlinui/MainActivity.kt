package com.zhangrenwen.kotlinui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zhangrenwen.kotlinui.base.BaseActivity
import com.zhangrenwen.kotlinui.ui.ListActivity
import com.zhangrenwen.kotlinui.ui.ListMustActivity
import com.zhangrenwen.kotlinui.ui.RecyclerViewActivity
import com.zhangrenwen.kotlinui.ui.UIActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        llTitle.setTitle("Kotlin实例")
    }

    fun progressBarClick(view: View) {
        startActivity(Intent(this, UIActivity::class.java))
    }
}