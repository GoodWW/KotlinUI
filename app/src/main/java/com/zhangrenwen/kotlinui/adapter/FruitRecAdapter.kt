package com.zhangrenwen.kotlinui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.bean.Fruit

/**
 * 作者：张人文
 * 时间：2020/12/10 16:37
 * 邮箱：479696877@QQ.COM
 * 描述：
 */
class FruitRecAdapter(val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitRecAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFruit: ImageView = view.findViewById(R.id.imgFruit)
        val tvFruitName: TextView = view.findViewById(R.id.tvFruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.imgFruit.setImageResource(fruit.imageId)
        holder.tvFruitName.text = fruit.name
    }
}