package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetectResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("url")
    val url: String,

    @SerializedName("detected_trash")
    val detected_trash: String,
)
