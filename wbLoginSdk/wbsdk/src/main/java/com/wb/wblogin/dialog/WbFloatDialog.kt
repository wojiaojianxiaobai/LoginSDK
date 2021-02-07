package com.wb.wblogin.dialog

import android.app.Activity
import android.content.Context
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.*
import android.widget.LinearLayout
import com.wb.wblogin.R
import com.wb.wblogin.dao.WbLogUtil
import java.util.jar.Attributes
import java.util.zip.Inflater

object WbFloatDialog {
    private var context: Context? = null
    var windowInfo: WindowInfo? = null

    class WindowInfo(var view: View?) {
        var layoutParams: WindowManager.LayoutParams? = null
        var width: Int = 0
        var height: Int = 0
        fun hasView() = view != null && layoutParams != null

        //'窗口中视图是否有父亲'
        fun hasParent() = hasView() && view?.parent != null
    }

    private fun show(
        context: Context, windowInfo: WindowInfo?,
        x: Int = windowInfo?.layoutParams?.x.value(),
        y: Int = windowInfo?.layoutParams?.x.value()
    ) {
        if (windowInfo == null) {
            WbLogUtil.v("windowInfo is null")
            return
        }
        if (windowInfo.view == null) {
            WbLogUtil.v("windowInfo view is null")
            return
        }
        this.windowInfo = windowInfo
        this.context = context
        windowInfo.layoutParams = createLayoutParam(x, y)
        WbLogUtil.v("show float window")
        if (!windowInfo.hasParent()) {
            WbLogUtil.v("float window no parent")
            val windowManager =
                this.context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowManager.addView(windowInfo.view, windowInfo.layoutParams)
        }
    }

    private fun createLayoutParam(x: Int, y: Int): WindowManager.LayoutParams {
        if (context == null) return WindowManager.LayoutParams()
        return WindowManager.LayoutParams().apply {
            type = WindowManager.LayoutParams.TYPE_APPLICATION  //应用级，不需要权限
            format = PixelFormat.TRANSLUCENT
            flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            gravity = Gravity.START or Gravity.TOP
            width = windowInfo?.width.value()
            height = windowInfo?.height.value()
            this.x = x
            this.y = y
        }
    }

    fun showUserFloatDialog(context: Context) {
        WbLogUtil.v("showUserFloatDialog")
        val windowView = LayoutInflater.from(context).inflate(R.layout.wb_float_layout, null)
        windowView.setOnTouchListener(onUserCenterTouchListener)
        WindowInfo(windowView).apply {
            width = 100
            height = 100
        }.let { windowInfo ->
            show(context, windowInfo, 0, 0)
            windowInfo.view?.setOnTouchListener(onUserCenterTouchListener)
        }
    }

    fun Int?.value() = this ?: 0

    private var lastX: Int = 0
    private var lastY: Int = 0

    object onUserCenterTouchListener : View.OnTouchListener {
        override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
            WbLogUtil.v("fire on float dialog touch")
            var currentX = p1?.rawX?.toInt()
            var currentY = p1?.rawY?.toInt()
            if (currentX == null || currentY == null) {
                return true
            }
            if (lastX == 0) {
                lastX = currentX
            }

            if (lastY == 0) {
                lastY = currentY
            }

            var dx = currentX.minus(lastX)
            var dy = currentY.minus(lastY)

            windowInfo?.layoutParams!!.x += dx
            lastX = currentX

            windowInfo?.layoutParams!!.y += dy
            lastY = currentY

            var windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            windowManager.updateViewLayout(windowInfo?.view, windowInfo?.layoutParams)
            return true
        }
    }


}