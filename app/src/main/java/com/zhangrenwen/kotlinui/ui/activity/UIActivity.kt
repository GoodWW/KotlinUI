package com.zhangrenwen.kotlinui.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zhangrenwen.kotlinui.ProgressBarActivity
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_u_i.*

class UIActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i)
        supportActionBar?.hide()
        llTitle.setTitle("UI")
    }

    fun progressBarClick(view: View) {
        startActivity(Intent(this, ProgressBarActivity::class.java))
    }

    fun alertDialogClick(view: View) {
        AlertDialog.Builder(this).apply {
            setTitle("这是消息标题")
            setMessage("消息内容")
            setCancelable(false)//设置是否可以取消
            setPositiveButton("确定") { dialog, which ->
                Toast.makeText(this@UIActivity, "确定", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("取消") { dialog, which ->
            }
        }.show()
    }

    fun listClick(view: View) {
        startActivity(Intent(this, ListActivity::class.java))
    }

    fun listMustClick(view: View) {
        startActivity(Intent(this, ListMustActivity::class.java))
    }

    fun recyclerViewClick(view: View) {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }

    fun chatClick(view: View) {
        startActivity(Intent(this, ChatActivity::class.java))
    }
}