package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("token")
    val token: String? = null
)
