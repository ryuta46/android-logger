package com.ryuta46.androidlogger

import android.util.Log

class Logger(val localTag: String) {
    companion object {
        const val LOG_LEVEL_NONE = 0
        const val LOG_LEVEL_ERROR = 1
        const val LOG_LEVEL_WARN = 2
        const val LOG_LEVEL_INFO = 3
        const val LOG_LEVEL_DEBUG = 4
        const val LOG_LEVEL_VERBOSE = 5

        @JvmStatic var tag = "AndroidLogger"
        @JvmStatic var level = LOG_LEVEL_NONE
    }

    fun e(message: String) {
        if (level >= LOG_LEVEL_ERROR) Log.e(tag, "|ERR|$localTag|$message")
    }

    fun w(message: String) {
        if (level >= LOG_LEVEL_WARN) Log.w(tag, "|WRN|$localTag|$message")
    }

    fun i(message: String) {
        if (level >= LOG_LEVEL_INFO) Log.i(tag, "|INF|$localTag|$message")
    }

    fun d(message: String) {
        if (level >= LOG_LEVEL_DEBUG) Log.d(tag, "|DBG|$localTag|$message")
    }

    fun v(message: String) {
        if (level >= LOG_LEVEL_VERBOSE) Log.v(tag, "|VRB|$localTag|$message")
    }

    inline fun <T> trace(body: () -> T): T {
        val callerName = if (level >= LOG_LEVEL_DEBUG) {
            Throwable().stackTrace[0].methodName
        } else {
            null
        }

        try {
            callerName?.let {
                d("$callerName start")
            }
            return body()
        }
        finally {
            callerName?.let {
                d("$callerName end")
            }
        }
    }
}

