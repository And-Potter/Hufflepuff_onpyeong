package com.example.androidseminar

import android.app.Application
import com.example.androidseminar.data.SoptUserAuthStorage.initSharedPreferences

class ApplicationController : Application() {

    override fun onCreate() {
        super.onCreate()
        initSharedPreferences(this)
    }
}