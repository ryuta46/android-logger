package com.ryuta46.androidlogger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val logger = Logger(this.javaClass.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.tag = "MyApp"
        Logger.level = Logger.LOG_LEVEL_DEBUG

        setupViews()
    }

    private fun setupViews() {
        logger.trace {
            logger.i("message")
        }
    }
}
