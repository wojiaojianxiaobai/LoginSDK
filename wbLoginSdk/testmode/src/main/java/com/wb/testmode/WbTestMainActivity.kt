package com.wb.testmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wb.wblogin.api.WbBaseCallback
import com.wb.wblogin.api.WbLoginCallback
import com.wb.wblogin.dao.WbLogUtil
import com.wb.wblogin.dao.WbSdk
import com.wb.wblogin.entity.UserData
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
                WbSdk.GameSDK.get().login(this@WbTestMainActivity,object :WbLoginCallback{
                    override fun onFail(wbError: WbError) {
                        WbLogUtil.v("登录失败" + wbError.code + wbError.message)
                    }

                    override fun onSuccess(t: UserData) {
                        WbLogUtil.v("登录成功" + t.uid + t.userName)
                    }

                })
            }

        })
    }
}