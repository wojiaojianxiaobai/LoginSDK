package com.wb.wblogin.api

import com.wb.wblogin.entity.WbError
import java.util.*

interface WbBaseCallback {
    fun<T> onSuccess(t:T)
    fun onFail(wbError: WbError)
}