package com.wb.wblogin.dao

import com.wb.wblogin.Util.Klog.KLog

object WbLogUtil {
    fun init(boolean: Boolean) {
        KLog.init(boolean)
    }

    fun v(content: String) {
        KLog.v("WbSDK", content)
    }

    fun v(tag: String, content: String) {
        if (tag.isEmpty()) {
            KLog.v("WbSDK", content)
        } else {
            KLog.v(tag, content)
        }
    }
}