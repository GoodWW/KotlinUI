package com.zhangrenwen.kotlinui.ui.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.adapter.FruitRecAdapter
import com.zhangrenwen.kotlinui.base.BaseActivity
import com.zhangrenwen.kotlinui.bean.Fruit
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewActivity : BaseActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initFruits()
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        val adapter = FruitRecAdapter(0, fruitList)
        recyclerview.adapter = adapter
    }

    private fun initFruits() {
        fruitList.clear()
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

    fun btnVerticalClick(view: View) {
        initFruits()
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        val adapter = FruitRecAdapter(0, fruitList)
        recyclerview.adapter = adapter
    }

    fun btnHorizontalClick(view: View) {
        initFruits()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = layoutManager
        val adapter = FruitRecAdapter(1, fruitList)
        recyclerview.adapter = adapter
    }

    fun btnWaterfallClick(view: View) {
        initWaterfallFruits()
        val layoutManager = StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL
        )
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerview.layoutManager = layoutManager
        val adapter = FruitRecAdapter(2, fruitList)
        recyclerview.adapter = adapter
    }

    fun btnGridClick(view: View) {
        initWaterfallFruits()
        val layoutManager = GridLayoutManager(this, 3)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerview.layoutManager = layoutManager
        val adapter = FruitRecAdapter(2, fruitList)
        recyclerview.adapter = adapter
    }

    private fun initWaterfallFruits() {
        fruitList.clear()
        repeat(2) {
            fruitList.add(Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthName(name: String): String {
        val length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(name)
        }
        return builder.toString()
    }


}