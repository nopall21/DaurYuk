//package com.example.mycapstone.data
//
//import androidx.lifecycle.LiveData
//import androidx.paging.PagingConfig
//import com.example.mycapstone.data.remote.response.FileUploadResponse
//import com.example.mycapstone.data.remote.retrofit.ApiService
//
//class AppRepository(private val apiService: ApiService) {
//    fun getWaste(): LiveData<PaggingData<FileUploadResponse>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 5
//            )
//        )
//    }
//
//    fun post
//}