package com.zhangrenwen.kotlinui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zhangrenwen.kotlinui.base.BaseActivity
import com.zhangrenwen.kotlinui.ui.activity.ActivityTestActivity
import com.zhangrenwen.kotlinui.ui.activity.FragmentActivity
import com.zhangrenwen.kotlinui.ui.activity.MultimediaActivity
import com.zhangrenwen.kotlinui.ui.activity.UIActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llTitle.setTitle("Kotlin实例")
    }

    fun uiClick(view: View) {
        startActivity(Intent(this, UIActivity::class.java))
    }

    fun fragmentClick(view: View) {
        startActivity(Intent(this, FragmentActivity::class.java))
    }

    fun multimedia(view: View) {
        startActivity(Intent(this, MultimediaActivity::class.java))
    }

    //跳转到 Activity 实例练习
    fun activityTest(view: View) {
        startActivity(Intent(this, ActivityTestActivity::class.java))
    }
}