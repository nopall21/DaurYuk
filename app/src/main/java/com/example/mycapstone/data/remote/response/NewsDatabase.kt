//package com.example.mycapstone.data.remote.response
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.mycapstone.data.local.entity.NewsEntity
//import com.example.mycapstone.data.local.room.NewsDao
//
//@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
//abstract class NewsDatabase : RoomDatabase() {
//    abstract fun newsDao(): NewsDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: NewsDatabase? = null
//
//        fun getInstance(context: Context): NewsDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    NewsDatabase::class.java,
//                    "news_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
