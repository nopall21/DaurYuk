package com.example.mycapstone.data.remote.retrofit

import com.example.mycapstone.data.remote.token.TokenRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit

class AuthInterceptor(private val tokenRepository: TokenRepository) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = tokenRepository.getToken()

        val requestBuilder = originalRequest.newBuilder()
        if (token != null) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}