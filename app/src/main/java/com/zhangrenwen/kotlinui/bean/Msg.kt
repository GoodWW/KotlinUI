package com.zhangrenwen.kotlinui.bean

/**
 * 作者：张人文
 * 时间：2020/12/11 15:30
 * 邮箱：479696877@QQ.COM
 * 描述：消息实体类
 */
class Msg(val content: String, val type: Int) {
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}