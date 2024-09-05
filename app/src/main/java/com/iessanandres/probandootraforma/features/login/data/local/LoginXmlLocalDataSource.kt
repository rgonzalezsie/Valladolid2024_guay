package com.iessanandres.probandootraforma.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences(
        "username", Context.MODE_PRIVATE)

    private val keyUserName="key_username"

    fun saveUsername(username: String) {
        val editor=sharedPref.edit()
        editor.putString(keyUserName, username)
        editor.commit()
    }

    fun deleteUsername() {
        val editor=sharedPref.edit()
        editor.remove(keyUserName)
        editor.commit()
    }

    fun getUsername(): String? {
        return sharedPref.getString(keyUserName, null)
    }
}