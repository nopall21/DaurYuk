//package com.example.mycapstone.data.di
//
//import android.content.Context
//import com.example.mycapstone.data.remote.response.NewsDatabase
//import com.example.mycapstone.data.remote.retrofit.ApiConfig
//import com.example.mycapstone.news.data.NewsRepository
//
//object Injection {
//    fun provideRepository(context: Context): NewsRepository {
//        val tokenHolder = TokenHolder.getInstance()
//        val apiService = ApiConfig.getApiService()
//        val database = NewsDatabase.getInstance(context)
//        val dao = database.newsDao()
//        return NewsRepository.getInstance(apiService, dao)
//    }
//}