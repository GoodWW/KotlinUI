package com.zhangrenwen.kotlinui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.adapter.FruitAdapter
import com.zhangrenwen.kotlinui.base.BaseActivity
import com.zhangrenwen.kotlinui.bean.Fruit
import kotlinx.android.synthetic.main.activity_list.*

class ListMustActivity : BaseActivity() {
    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initFruits()
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        list.adapter = adapter
        list.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this, "点击${fruit.name}", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }
}