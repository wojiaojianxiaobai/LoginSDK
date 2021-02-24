package com.wb.testmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wb.wblogin.api.WbBaseCallback
import com.wb.wblogin.api.WbLoginCallback
import com.wb.wblogin.dao.WbLogUtil
import com.wb.wblogin.dao.WbSdk
import com.wb.wblogin.dialog.WbFloatDialog
import com.wb.wblogin.dialog.WbLoginDialog
import com.wb.wblogin.entity.UserData
import com.wb.wblogin.entity.WbError

class WbTestMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wb_test_activity_main)
        WbSdk.GameSDK.getInStance().onCreate(this)
        WbSdk.GameSDK.getInStance().init(this,object :WbBaseCallback{
            override fun onFail(wbError: WbError) {
                WbLogUtil.v("初始化失败")
            }

            override fun <T> onSuccess(t: T) {
                WbLogUtil.v("初始化成功")
                WbSdk.GameSDK.getInStance().login(this@WbTestMainActivity,object :WbLoginCallback{
                    override fun onFail(wbError: WbError) {
                        WbLogUtil.v("登录失败" + wbError.code + wbError.message)
                    }

                    override fun onSuccess(t: UserData) {
                        WbLogUtil.v("登录成功" + t.uid + t.userName)
                        WbFloatDialog.showUserFloatDialog(this@WbTestMainActivity)

                    }

                })
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            WbSdk.GameSDK.getInStance().onActivityResult(requestCode, resultCode, data)
        }
    }
}