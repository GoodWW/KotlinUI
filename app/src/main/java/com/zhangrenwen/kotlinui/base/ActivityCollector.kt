package com.zhangrenwen.kotlinui.base

import android.app.Activity

/**
 * 作者：张人文
 * 时间：2020/12/9 14:44
 * 邮箱：479696877@QQ.COM
 * 描述：存放Activity的集合
 *   object  是单例类的关键字  比静态方法更好
 */
object ActivityCollector {
    //存放Activity的集合
    private val activities = ArrayList<Activity>()

    //添加activity
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    //移除activity
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    //关闭所有activity
    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
        //杀掉当前进程
        android.os.Process.killProcess(android.os.Process.myPid())
    }
}