package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class RewardListResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("length")
    val length: Int,

    @SerializedName("rewards")
    val rewards: List<RewardsItem>,

    )

data class RewardsItem(
    @SerializedName("name")
    val name: String,

    @SerializedName("required_points")
    val required_points: Int,

    @SerializedName("id")
    val id: Any?,

    @SerializedName("claimable")
    val claimable: Boolean,
)

