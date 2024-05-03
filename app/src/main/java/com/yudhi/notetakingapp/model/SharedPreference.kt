package com.yudhi.notetakingapp.model

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.core.content.edit

object SharedPreference {
    private const val PREF_NAME = "user_pref"
    private const val KEY_USERNAME = "username"
    private const val KEY_PASSWORD = "password"
    private const val EMAIL_PASSWORD = "email"

    fun saveAccount(context: Context, username: String, password: String, email: String) {
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(KEY_USERNAME, username)
            putString(KEY_PASSWORD, password)
            putString(EMAIL_PASSWORD, email)
            apply()
        }
    }

    fun getSavedAccount(context: Context): Pair<String?, String?> {
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val username = sharedPref.getString(KEY_USERNAME, null)
        val password = sharedPref.getString(KEY_PASSWORD, null)
        return Pair(username, password)
    }

    fun clearAccount(context: Context) {
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            remove(KEY_USERNAME)
            remove(KEY_PASSWORD)
            apply()
        }
    }
}
