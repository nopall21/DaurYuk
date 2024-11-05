package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class UpdateRewardBalanceResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("statusCode")
    val statusCode: String,

    @SerializedName("message")
    val message: String,

    @SerializedName("rewards_balance")
    val rewards_balance: Int,
)
