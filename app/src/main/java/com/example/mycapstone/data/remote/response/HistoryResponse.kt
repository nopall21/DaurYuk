package com.example.mycapstone.data.remote.response

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("length")
	val length: Int? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class DataItem(

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("detectedAt")
	val detectedAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("userId")
	val userId: String? = null
)
