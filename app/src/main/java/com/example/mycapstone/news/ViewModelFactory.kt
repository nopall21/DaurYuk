//package com.example.mycapstone.news
//
//import android.content.Context
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.mycapstone.news.data.NewsRepository
//import com.example.mycapstone.news.data.di.Injection
//import com.example.mycapstone.news.ui.detail.NewsDetailViewModel
//import com.example.mycapstone.news.ui.list.NewsViewModel
//
//class ViewModelFactory private constructor(private val newsRepository: NewsRepository) :
//    ViewModelProvider.NewInstanceFactory() {
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
//            return NewsViewModel(newsRepository) as T
//        } else if (modelClass.isAssignableFrom(NewsDetailViewModel::class.java)) {
//            return NewsDetailViewModel(newsRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
//    }
//
//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//        fun getInstance(context: Context): ViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: ViewModelFactory(Injection.provideRepository(context))
//            }.also { instance = it }
//    }
//}