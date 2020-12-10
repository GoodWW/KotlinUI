package com.zhangrenwen.kotlinui.custom_view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.zhangrenwen.kotlinui.R
import kotlinx.android.synthetic.main.title_layout.view.*

/**
 * 作者：张人文
 * 时间：2020/12/10 14:07
 * 邮箱：479696877@QQ.COM
 * 描述：自定义头部布局
 */
class TitleLayout(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title_layout, this)
        btnBack.setOnClickListener {
            val activity = context as Activity//类型强制转换使用的是 as
            activity.finish()
        }
        btnExit.setOnClickListener {
            Toast.makeText(context, "点击了退出按钮", Toast.LENGTH_SHORT).show()
        }
    }

    fun setTitle(string: String) {
        tvTitle.text = string
    }

}