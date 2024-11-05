package com.example.mycapstone.data.remote.token

import com.google.gson.annotations.SerializedName

data class AuthToken(
    @SerializedName("token")
    val token: String,
)
