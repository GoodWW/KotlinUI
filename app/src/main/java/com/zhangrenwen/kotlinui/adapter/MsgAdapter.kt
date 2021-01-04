package com.zhangrenwen.kotlinui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.bean.Msg
import com.zhangrenwen.kotlinui.viewholder.LeftViewHolder
import com.zhangrenwen.kotlinui.viewholder.MsgViewHolder
import com.zhangrenwen.kotlinui.viewholder.RightViewHolder

/**
 * 作者：张人文
 * 时间：2020/12/11 15:35
 * 邮箱：479696877@QQ.COM
 * 描述：
 */
class MsgAdapter(val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {
//    inner class LeftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
//    }
//
//    inner class RightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        if (viewType == Msg.TYPE_RECEIVED) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            val viewHolder: LeftViewHolder = LeftViewHolder(view)
            return viewHolder
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            val viewHolder: RightViewHolder = RightViewHolder(view)
            return viewHolder
        }
    }


    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

    override fun getItemViewType(position: Int) = msgList[position].type
    override fun getItemCount() = msgList.size
}