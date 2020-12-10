package com.zhangrenwen.kotlinui.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.bean.Fruit

/**
 * 作者：张人文
 * 时间：2020/12/10 15:14
 * 邮箱：479696877@QQ.COM
 * 描述：
 */
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    inner class ViewHolder(val imgFruit: ImageView, val tvFruitName: TextView)

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        一般使用
//        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        val imgFruit: ImageView = view.findViewById(R.id.imgFruit)
//        val tvFruitName: TextView = view.findViewById(R.id.tvFruitName)
//        val fruit = getItem(position)
//        if (fruit != null) {
//            imgFruit.setImageResource(fruit.imageId)
//            tvFruitName.text = fruit.name
//        }
//        return view

        //提升效率
//        val view: View
//        if (convertView == null) {
//            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        } else {
//            view = convertView
//        }
//        val imgFruit: ImageView = view.findViewById(R.id.imgFruit)
//        val tvFruitName: TextView = view.findViewById(R.id.tvFruitName)
//        val fruit = getItem(position)
//        if (fruit != null) {
//            imgFruit.setImageResource(fruit.imageId)
//            tvFruitName.text = fruit.name
//        }
//        return view
        //再继续优化
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val imgFruit: ImageView = view.findViewById(R.id.imgFruit)
            val tvFruitName: TextView = view.findViewById(R.id.tvFruitName)
            viewHolder = ViewHolder(imgFruit, tvFruitName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.imgFruit.setImageResource(fruit.imageId)
            viewHolder.tvFruitName.text = fruit.name
        }
        return view

    }

}