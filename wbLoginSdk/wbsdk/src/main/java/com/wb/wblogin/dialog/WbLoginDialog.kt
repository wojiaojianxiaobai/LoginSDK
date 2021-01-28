package com.wb.wblogin.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.wb.wblogin.R
import com.wb.wblogin.api.WbLoginCallback
import com.wb.wblogin.dao.WbLogUtil
import com.wb.wblogin.entity.UserData

class WbLoginDialog :Dialog{
    constructor(context: Context): super(context){

    }
    constructor(context: Context,theme:Int): super(context,theme){

    }

    class Builder(context: Context,wbLoginCallback: WbLoginCallback){
        private val dialog: WbLoginDialog = WbLoginDialog(context)
        init {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = inflater.inflate(R.layout.wb_login_activity,null)
            dialog.addContentView(layout,ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT))
            layout.findViewById<View>(R.id.login_enter_btn).setOnClickListener(View.OnClickListener {
                val userData = UserData()
                userData.uid = layout.findViewById<EditText>(R.id.login_username).text.toString()
                userData.userName = "测试用户"
                WbLogUtil.v("登录成功: uid: " + userData.uid)
                wbLoginCallback.onSuccess(userData)
            })
            layout.findViewById<View>(R.id.login_cancel_btn).setOnClickListener(View.OnClickListener {
                WbLogUtil.v("取消登录")
            })
            dialog.show()
        }
    }

}