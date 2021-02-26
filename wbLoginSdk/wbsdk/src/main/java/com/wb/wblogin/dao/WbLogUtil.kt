package com.wb.wblogin.dao

import com.wb.wblogin.Util.Klog.KLog
import com.wb.wblogin.config.WbAppConfig

object WbLogUtil {
    fun init(boolean: Boolean) {
        KLog.init(boolean)
    }

    fun v(content: String) {
        KLog.v(WbAppConfig.SDK_NAME, content)
    }

    fun v(tag: String, content: String) {
        if (tag.isEmpty()) {
            KLog.v(WbAppConfig.SDK_NAME, content)
        } else {
            KLog.v(tag, content)
        }
    }
}