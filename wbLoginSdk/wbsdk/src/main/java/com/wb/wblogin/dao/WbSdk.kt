package com.wb.wblogin.dao

import android.app.Activity
import com.wb.wblogin.Util.Klog.KLog
import com.wb.wblogin.api.WbBaseCallback
import com.wb.wblogin.api.WbSdkApi

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
        WbLogUtil.init(true)
        WbLogUtil.v("wbsdk init")
        wbBaseCallback.onSuccess(null)
    }

    override fun login(activity: Activity,wbBaseCallback: WbBaseCallback) {
        WbLogUtil.v("wbsdk login")
    }

    override fun onCreate(activity: Activity) {
        KLog.init(true);
        WbLogUtil.v("wbsdk","wbsdk onCreate")
    }
}