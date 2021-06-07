package com.example.androidseminar.data

import android.content.Context
import android.content.SharedPreferences

object SoptUserAuthStorage {
    private const val STORAGE_KEY = "user_auth"
    private const val AUTO_LOGIN = "auto_login"

    private lateinit var sharedPreferences : SharedPreferences

    fun initSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE)
    }

    fun saveAutoLogin(autoLogin : Boolean) {
        sharedPreferences.edit()
            .putBoolean(AUTO_LOGIN, autoLogin)
            .apply()
    }

    fun getAutoLogin() : Boolean {
        return sharedPreferences.getBoolean(AUTO_LOGIN, false)
    }

    fun clearAutoLogin() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}