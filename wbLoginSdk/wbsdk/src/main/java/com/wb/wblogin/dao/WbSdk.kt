package com.wb.wblogin.dao

import android.app.Activity
import com.wb.wblogin.Util.Klog.KLog
import com.wb.wblogin.api.WbBaseCallback
import com.wb.wblogin.api.WbLoginCallback
import com.wb.wblogin.api.WbSdkApi
import com.wb.wblogin.dialog.WbLoginDialog
import com.wb.wblogin.entity.UserData

class WbSdk : WbSdkApi{
     class GameSDK private constructor() {
        companion object {
            private var instance: WbSdk? = null
                get() {
                    if (field == null) {
                        field = WbSdk()
                    }
                    return field
                }
            fun get():WbSdk{
                return instance!!
            }
        }
    }

    override fun init(activity: Activity,wbBaseCallback: WbBaseCallback) {
        WbLogUtil.v("fire on wbsdk init")
        WbLogUtil.init(true)
        wbBaseCallback.onSuccess(null)
    }

    override fun login(activity: Activity,wbLoginCallback: WbLoginCallback) {
        WbLogUtil.v("fire on wbsdk login")

        WbLoginDialog.Builder(activity,wbLoginCallback)

    }

    override fun onCreate(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onCreate")
        KLog.init(true);
    }
}