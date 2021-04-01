package com.wb.wblogin.dao

import android.app.Activity
import android.content.Intent
import com.wb.wblogin.Util.Klog.KLog
import com.wb.wblogin.api.WbBaseCallback
import com.wb.wblogin.api.WbLoginCallback
import com.wb.wblogin.api.WbLogoutCallback
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

    private var wbSdkApi:WbSdkApi? = null

    fun getSdkApi(activity: Activity) : WbSdkApi {
        synchronized("WbSdkApi"){
            if (wbSdkApi == null){
                wbSdkApi = Class.forName("com.wb.wblogin.dao.WbCommonSdk")
                    .newInstance() as WbSdkApi?
            }
            return wbSdkApi!!
        }
    }

    override fun init(activity: Activity,wbBaseCallback: WbBaseCallback) {
        WbLogUtil.v("fire on wbsdk init")
        getSdkApi(activity).init(activity, wbBaseCallback)
    }

    override fun login(activity: Activity,wbLoginCallback: WbLoginCallback) {
        WbLogUtil.v("fire on wbsdk login")
        getSdkApi(activity).login(activity, wbLoginCallback)
    }

    override fun onCreate(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onCreate")
        getSdkApi(activity).onCreate(activity)
    }

    override fun onStart(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onStart")
        getSdkApi(activity).onStart(activity)
    }

    override fun onResume(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onResume")
        getSdkApi(activity).onResume(activity)
    }

    override fun onPause(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onPause")
        getSdkApi(activity).onPause(activity)
    }

    override fun onStop(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onStop")
        getSdkApi(activity).onStop(activity)
    }

    override fun onDestroy(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk onDestroy")
        getSdkApi(activity).onDestroy(activity)
    }

    override fun onActivityResult(activity: Activity,requestCode: Int, resultCode: Int, data: Intent) {
        WbLogUtil.v("wbsdk","fire on wbsdk onActivityResult")
        getSdkApi(activity).onActivityResult(activity,requestCode, resultCode, data)
    }

    override fun logout(activity: Activity,logoutCallback: WbLogoutCallback) {
        WbLogUtil.v("wbsdk","fire on wbsdk logout")
        getSdkApi(activity).logout(activity,logoutCallback)
    }

    override fun pay(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk pay")
        getSdkApi(activity).pay(activity)
    }

    override fun sendRoleCreateData(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleCreateData")
        getSdkApi(activity).sendRoleCreateData(activity)
    }

    override fun sendRoleLoginData(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleLoginData")
        getSdkApi(activity).sendRoleLoginData(activity)
    }

    override fun sendRoleLevelData(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleLevelData")
        getSdkApi(activity).sendRoleLoginData(activity)
    }

    override fun sendRoleExitData(activity: Activity) {
        WbLogUtil.v("wbsdk","fire on wbsdk sendRoleExitData")
        getSdkApi(activity).sendRoleExitData(activity)
    }
}