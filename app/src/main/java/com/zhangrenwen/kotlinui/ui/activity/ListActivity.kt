package com.zhangrenwen.kotlinui.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {
    private val date = listOf<String>(
        "Apple", "Banana", "Orange", "Apple", "Banana", "Orange"
        , "Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange",
        "Apple", "Banana", "Orange", "Apple", "Banana", "Orange"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,date)
        list.adapter = adapter
    }
}