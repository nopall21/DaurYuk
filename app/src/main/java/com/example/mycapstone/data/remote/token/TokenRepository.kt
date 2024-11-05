package com.example.mycapstone.data.remote.token

import android.content.Context
import android.content.SharedPreferences

class TokenRepository(private val context: Context) {
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("token_pref", Context.MODE_PRIVATE)
    }

    // Save token
    fun saveToken(token: String) {
        sharedPreferences.edit().putString("jwt_token", token).apply()
    }

    // Get token
    fun getToken(): String? {
        return sharedPreferences.getString("jwt_token", null)
    }

    // Clear token
    fun clearToken() {
        sharedPreferences.edit().remove("jwt_token").apply()
    }
}