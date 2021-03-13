package com.zhangrenwen.kotlinui.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.content.FileProvider
import com.zhangrenwen.kotlinui.R
import com.zhangrenwen.kotlinui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.File

/**
 * 拍照和相册
 */
class CameraActivity : BaseActivity() {


    val takePhoto = 1

    //存放摄像头拍下的照片
    lateinit var outputImage: File

    //存放拍照后的图片的  Uri
    lateinit var imageUrl: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
    }

    //拍照点击事件
    fun takePhoto(view: View) {
        //创建 File 对象  存放拍照后的图片在缓存中  externalCacheDir 是获取缓存目录
        outputImage = File(externalCacheDir, "output_image.jpg")
        if (outputImage.exists()) {
            outputImage.delete()
        }
        outputImage.createNewFile()
        //进行 系统版本判断得到 不同版本获得  Uri 对象的方式不同
        imageUrl = if (Build.VERSION.SDK_INT >=
            Build.VERSION_CODES.N
        ) {//大于7.0
            FileProvider.getUriForFile(
                this,
                "com.zhangrenwen.kotlinui.ui.activity.cameraActivity",
                outputImage
            )//第二个参数  可以是任意唯一字符串
        } else {//d低于7.0
            Uri.fromFile(outputImage)
        }

        //启动相机程序   隐世启动  值为 android.media.action.IMAGE_CAPTURE
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //这句作用是如果没有相机则该应用不会闪退，要是不加这句则当系统没有相机应用的时候该应用会闪退
        if (intent.resolveActivity(packageManager) != null) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUrl)
            startActivityForResult(intent, takePhoto);//启动相机
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            takePhoto -> {
                if (resultCode == Activity.RESULT_OK) {
                    //将拍摄的照片显示出来
                    val bitmap = BitmapFactory.decodeStream(
                        contentResolver.openInputStream(imageUrl)
                    )
                    imageView.setImageBitmap(rotateIfRequired(bitmap))
                }
            }
        }
    }

    private fun rotateIfRequired(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        val orientation = exif.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_NORMAL
        )
        return when (orientation) {

            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 18)
            else -> bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotateBitmap = Bitmap.createBitmap(
            bitmap, 0, 0,
            bitmap.width, bitmap.height, matrix, true
        )
        bitmap.recycle()//将不再需要的  bitmap 回收
        return rotateBitmap
    }


    //相册点击事件
    fun fromAlbum(view: View) {}


}