package com.wb.wblogin.api

import com.wb.wblogin.entity.UserData
import com.wb.wblogin.entity.WbError

interface WbLogoutCallback{
    fun<T> onSuccess(t:T)
    fun onFail(wbError: WbError)
}