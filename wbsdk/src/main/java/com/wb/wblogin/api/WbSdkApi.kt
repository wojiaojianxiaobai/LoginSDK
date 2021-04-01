package com.wb.wblogin.api

import android.app.Activity
import android.content.Intent

interface WbSdkApi {
    fun onCreate(activity:Activity)
    fun onStart(activity: Activity)
    fun onResume(activity: Activity)
    fun onPause(activity: Activity)
    fun onStop(activity: Activity)
    fun onDestroy(activity: Activity)
    fun init(activity: Activity,wbBaseCallback: WbBaseCallback)
    fun onActivityResult(activity: Activity,requestCode: Int,resultCode: Int,data: Intent)
    fun login(activity: Activity,wbLoginCallback: WbLoginCallback)
    fun logout(activity: Activity,logoutCallback: WbLogoutCallback)
    fun pay(activity: Activity)
    fun sendRoleCreateData(activity: Activity)
    fun sendRoleLoginData(activity: Activity)
    fun sendRoleLevelData(activity: Activity)
    fun sendRoleExitData(activity: Activity)
}