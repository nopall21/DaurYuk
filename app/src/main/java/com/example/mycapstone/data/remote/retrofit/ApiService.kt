package com.example.mycapstone.data.remote.retrofit

import com.example.mycapstone.data.remote.response.ClaimRewardResponse
import com.example.mycapstone.data.remote.response.DetectResponse
import com.example.mycapstone.data.remote.response.HistoryResponse
import com.example.mycapstone.data.remote.response.LoginResponse
import com.example.mycapstone.data.remote.response.ProfileResponse
import com.example.mycapstone.data.remote.response.RegisterResponse
import com.example.mycapstone.data.remote.response.RewardListResponse
import com.example.mycapstone.data.remote.response.UpdateRewardBalanceResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
//    @GET("top-headlines?country=id&category=science")
//    suspend fun getNews(@Query("apiKey") apiKey: String): NewsResponse
//
//    companion object {
//        fun create(): ApiService {
//            val retrofit = Retrofit.Builder()
//                .baseUrl(ApiConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            return retrofit.create(ApiService::class.java)
//        }
//    }

//    @GET("")
//    fun verifyAccount (@Path("token") token: String): Call<>

//    @POST("/register")
//    fun register(
////        @Body request: RegisterRequest
//    ):Call<RegisterResponse>
//
//    @POST("/login")
//    fun login(
//        @Body request: LoginRequest
//    ):Call<LoginResponse>
//
//    @GET("/reward/claim")
//    fun claimReward(
//        @Query("rewardId") rewardId: String
//    ):Call<ClaimRewardResponse>
//
//    @GET("/reward-balance")
//    fun updateRewardBalance(
//        @Header("Authorization") token: String,
//        @Query("point") point: Int
//    ):Call<UpdateRewardBalanceResponse>
//
//    @GET("/rewards")
//    fun getRewards(
//        @Field("rewards") rewards: String
//    ):Call<RewardListResponse>
//
//    @Multipart
//    @POST("/detect")
//    suspend fun uploadImage(
//        @Header("Authorization") token: String,
//        @Part file: MultipartBody.Part
//    ):Response<DetectResponse>
//
//    @GET("/profile")
//    fun getProfile(
//        @Body requestBody: RequestBody
//    ):Callback<ProfileResponse>
//
//    @GET("/detect-history")
//    suspend fun getHistory(
//        @Header("Authorization") token: String,
//    ):Response<HistoryResponse>
}
