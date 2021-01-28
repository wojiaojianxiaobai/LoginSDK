package com.wb.wblogin.api

import com.wb.wblogin.entity.UserData
import com.wb.wblogin.entity.WbError

interface WbLoginCallback{
    fun onSuccess(t:UserData)
    fun onFail(wbError: WbError)
}