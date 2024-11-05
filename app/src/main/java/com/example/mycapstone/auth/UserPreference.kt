package com.example.mycapstone.auth

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {
    companion object {
        private val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
        private val USERNAME_KEY = stringPreferencesKey("username")
        private var INSTANCE: UserPreference? = null

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserPreference(dataStore).also { INSTANCE = it }
            }
        }
    }

    suspend fun saveLoginState(isLoggedIn: Boolean, username: String) {
        dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN_KEY] = isLoggedIn
            preferences[USERNAME_KEY] = username
        }
    }

    val isLoggedIn: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[IS_LOGGED_IN_KEY] ?: false
        }

    val username: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[USERNAME_KEY] ?: "Guest"
        }

    suspend fun clearPreferences() {
        dataStore.edit { it.clear() }
    }
}
