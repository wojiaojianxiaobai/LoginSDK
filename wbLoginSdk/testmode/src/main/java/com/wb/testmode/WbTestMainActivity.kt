package com.wb.testmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wb.wblogin.api.WbBaseCallback
import com.wb.wblogin.dao.WbLogUtil
import com.wb.wblogin.dao.WbSdk
import com.wb.wblogin.entity.WbError

class WbTestMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wb_test_activity_main)
        WbSdk.GameSDK.get().onCreate(this)
        WbSdk.GameSDK.get().init(this,object :WbBaseCallback{
            override fun onFail(wbError: WbError) {
                WbLogUtil.v("初始化失败")
            }

            override fun <T> onSuccess(t: T) {
                WbLogUtil.v("初始化成功")
            }

        })
    }
}