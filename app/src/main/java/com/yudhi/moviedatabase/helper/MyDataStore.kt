package com.yudhi.moviedatabase.helper

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


object MyDataStore {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")
    private val KEY_USERNAME = stringPreferencesKey("username")
    private val KEY_PASSWORD = stringPreferencesKey("password")
    private val EMAIL_PASSWORD = stringPreferencesKey("email")

    suspend fun saveAccount(context: Context, username: String, password: String, email: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_USERNAME] = username
            preferences[KEY_PASSWORD] = password
            preferences[EMAIL_PASSWORD] = email
        }
    }

    fun getSavedAccount(context: Context): Flow<Triple<String?, String?, String?>> {
        return context.dataStore.data.map { preferences ->
            val username = preferences[KEY_USERNAME]
            val password = preferences[KEY_PASSWORD]
            val email = preferences[EMAIL_PASSWORD]
            Triple(username, password, email)
        }
    }

    suspend fun clearAccount(context: Context) {
        context.dataStore.edit { preferences ->
            preferences.remove(KEY_USERNAME)
            preferences.remove(KEY_PASSWORD)
            preferences.remove(EMAIL_PASSWORD)
        }
    }


}
