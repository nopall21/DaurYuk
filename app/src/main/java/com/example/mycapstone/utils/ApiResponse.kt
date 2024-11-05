package com.example.mycapstone.utils

@Suppress("UNUSED_PARAMETER")
//sealed class to help organize api response whether success, error, or empty
sealed class ApiResponse<T>(
    data: T? = null,
    errorMessage: String?
) {
    data class Success<T>(val data: T) : ApiResponse<T>(data,null)

    data class Status<T>(
        val statusMessage: String
    ) : ApiResponse<T>(null, statusMessage)
}