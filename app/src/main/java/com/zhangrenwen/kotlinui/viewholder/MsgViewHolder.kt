package com.zhangrenwen.kotlinui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhangrenwen.kotlinui.R

/**
 * 作者：张人文
 * 时间：2020/12/11 15:30
 * 邮箱：479696877@QQ.COM
 * 描述：密封类案例
 */
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View) : MsgViewHolder(view) {
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)
}