package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class VerifyAccountResponse (
    @SerializedName("status")
    val status: String,

    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("message")
    val message: String,
)
