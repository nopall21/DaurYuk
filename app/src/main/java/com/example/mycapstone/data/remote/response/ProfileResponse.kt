package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse (
    @SerializedName("status")
    val status: String,

    @SerializedName("statusCode")
    val statusCode: String,

    @SerializedName("data")
    var data: Data
)

data class Data(
    @SerializedName("id")
    var id: String? = null,

    @SerializedName("profile")
    var profile: Profile,

    @SerializedName("email")
    var email: String,
)

class Profile(
    @SerializedName("name")
    var name: String,
)