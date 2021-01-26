package com.wb.wblogin.api

import android.app.Activity

interface WbSdkApi {
    fun init(activity: Activity,wbBaseCallback: WbBaseCallback)
    fun login(activity: Activity,wbBaseCallback: WbBaseCallback)
    fun onCreate(activity:Activity)
}