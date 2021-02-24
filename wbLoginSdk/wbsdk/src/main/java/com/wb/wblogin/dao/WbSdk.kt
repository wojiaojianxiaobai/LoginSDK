package com.wb.wblogin.dao

import android.app.Activity
import android.content.Intent
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
            fun getInStance():WbSdk{
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

    override fun onStart(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onStart")

    }

    override fun onResume(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onResume")

    }

    override fun onPause(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onPause")
    }

    override fun onStop(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onStop")
    }

    override fun onDestroy(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        WbLogUtil.v("wbsdk","fire on wbsdk onActivityResult")
    }

    override fun logout(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk logout")
    }

    override fun pay(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk pay")
    }

    override fun sendRoleCreateData() {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleCreateData")
    }

    override fun sendRoleLoginData() {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleLoginData")
    }

    override fun sendRoleLevelData() {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleLevelData")
    }

    override fun sendRoleExitData() {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleExitData")
    }
}