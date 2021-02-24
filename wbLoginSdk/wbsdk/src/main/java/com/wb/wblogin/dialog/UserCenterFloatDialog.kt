package com.wb.wblogin.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wb.wblogin.R
import com.wb.wblogin.dao.WbLogUtil
class UserCenterFloatDialog  : Dialog {
//    private fun show(context: Context){
//        var windowManager = LayoutInflater.from(context).inflate(R.layout.wb_user_center_main_activity,null)
//
//    }

    var mContext: Context
    var view: View
//    var userCenterFloatDialog : UserCenterFloatDialog? = null
    companion object {
    @SuppressLint("StaticFieldLeak")
    var userCenterFloatDialog : UserCenterFloatDialog? = null

    fun getInstance(context: Context) :UserCenterFloatDialog{
            if (userCenterFloatDialog == null){
                userCenterFloatDialog = UserCenterFloatDialog(context)
            }
        return userCenterFloatDialog as UserCenterFloatDialog
        }
    }
    constructor(context: Context) : super(context){
        this.mContext = context
        setContentView(R.layout.wb_user_center_main_activity)
        view = LayoutInflater.from(context).inflate(R.layout.wb_user_center_main_activity,null)
        setOnclickListener()
    }

//    fun getInstance() :UserCenterFloatDialog {
//        if (userCenterFloatDialog == null){
//            userCenterFloatDialog = UserCenterFloatDialog(context)
//        }
//        return userCenterFloatDialog as UserCenterFloatDialog
//    }

    override fun show() {
        super.show()
    }

    override fun dismiss() {
        super.dismiss()
    }

    private fun setOnclickListener(){
        view.findViewById<Button>(R.id.user_center_cancel_login).setOnClickListener(View.OnClickListener {
            WbLogUtil.v("取消登录")
        })
    }
}