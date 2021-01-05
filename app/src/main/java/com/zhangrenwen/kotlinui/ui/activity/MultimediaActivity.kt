package com.zhangrenwen.kotlinui.ui.activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.base.BaseActivity

class MultimediaActivity : BaseActivity() {

    private lateinit var manager: NotificationManager
    private lateinit var notificationBtn: Notification

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multimedia)
        //获取  NotificationManager   实例对象
        if (!::manager.isInitialized)
            manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //创建通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "com.zhangrenwen.kotlinui.ui.activity.MultimediaActivity",
                "测试渠道", NotificationManager.IMPORTANCE_DEFAULT
            )//通知渠道重要等级默认

            val channel2 = NotificationChannel(
                "com.zhangrenwen.kotlinui.ui.activity.MultimediaActivity1",
                "测试渠道等级高", NotificationManager.IMPORTANCE_HIGH
            )//通知渠道重要等级高
            manager.createNotificationChannel(channel2)
        }
    }

    fun notification(view: View) {

        //模拟通知跳转的页面
        val intent = Intent(this, ChatActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)


        if (!::notificationBtn.isInitialized)
//            notificationBtn = NotificationCompat.Builder(
//                this,
//                "com.zhangrenwen.kotlinui.ui.activity.MultimediaActivity"
//            ) //通知渠道重要等级默认

            notificationBtn = NotificationCompat.Builder(
                this,
                "com.zhangrenwen.kotlinui.ui.activity.MultimediaActivity1"
            )//通知渠道重要等级高
                .setContentTitle("内容标题")//长了会默认省略
//                .setContentText("内容文字")//长了会默认省略

//                .setStyle(NotificationCompat.BigTextStyle().bigText("内容文字" +
//                        "内容文字内容文字内容文字内容文字内容文字内容文字内容文字" +
//                        "内容文字内容文字内容文字内容文字内容文字内容文字内容文字" +
//                        "内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字"))//封装长文字信息

                .setStyle(
                    NotificationCompat.BigPictureStyle().bigPicture(
                        BitmapFactory.decodeResource(resources, R.drawable.butful_girl)
                    )
                )//显示一张大图片

                .setSmallIcon(R.drawable.apple_pic)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.butful_girl_v))
                .setContentIntent(pi)
                .setAutoCancel(true)//点击就消失
                .build()

        manager.notify(1, notificationBtn)

        //        manager.cancel(1)  另外一种取消的方法  在点击事件结束后取消
    }

    fun camera(view: View) {
        startActivity(Intent(this, CameraActivity::class.java))
    }
    fun multimediaPlay(view: View) {}
}