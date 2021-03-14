package com.zhangrenwen.kotlinui.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.base.BaseActivity

/**
 * 作者：张人文
 * 时间：2020/12/9 14:30
 * 邮箱：479696877@QQ.COM
 * 描述：Activity  练习
 */
class ActivityTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)
    }

    fun menuClick(view: View) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_test,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item ->
                Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show()
            R.id.remove_item ->
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}