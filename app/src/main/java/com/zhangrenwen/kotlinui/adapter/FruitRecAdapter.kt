package com.zhangrenwen.kotlinui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.bean.Fruit

/**
 * 作者：张人文
 * 时间：2020/12/10 16:37
 * 邮箱：479696877@QQ.COM
 * 描述：
 */
class FruitRecAdapter(val type: Int, val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitRecAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFruit: ImageView = view.findViewById(R.id.imgFruit)
        val tvFruitName: TextView = view.findViewById(R.id.tvFruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        val viewHolder: ViewHolder
        if (type == 0) {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
            viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val position = viewHolder.adapterPosition
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "点击${fruit.name}", Toast.LENGTH_SHORT).show()
            }
            viewHolder.imgFruit.setOnClickListener {
                val position = viewHolder.adapterPosition
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "点击图片${fruit.name}", Toast.LENGTH_SHORT).show()
            }
            return viewHolder
        } else if (type == 1) {
            view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fruit_item_horizontal, parent, false)
            viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val position = viewHolder.adapterPosition
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "点击${fruit.name}", Toast.LENGTH_SHORT).show()
            }
            viewHolder.imgFruit.setOnClickListener {
                val position = viewHolder.adapterPosition
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "点击图片${fruit.name}", Toast.LENGTH_SHORT).show()
            }
            return viewHolder
        } else if (type == 2) {
            view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fruit_item_waterfall, parent, false)
            viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val position = viewHolder.adapterPosition
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "点击${fruit.name}", Toast.LENGTH_SHORT).show()
            }
            viewHolder.imgFruit.setOnClickListener {
                val position = viewHolder.adapterPosition
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "点击图片${fruit.name}", Toast.LENGTH_SHORT).show()
            }
            return viewHolder
        }
        view =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "点击${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.imgFruit.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "点击图片${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.imgFruit.setImageResource(fruit.imageId)
        holder.tvFruitName.text = fruit.name
    }
}