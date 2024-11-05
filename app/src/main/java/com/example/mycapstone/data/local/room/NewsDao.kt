//package com.example.mycapstone.data.local.room
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.mycapstone.data.local.entity.NewsEntity
//import com.example.mycapstone.history.db.History
//
//@Dao
//interface NewsDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun saveNews(news: NewsEntity)
//
//    @Query("DELETE FROM news WHERE title = :newsTitle")
//    suspend fun deleteNews(newsTitle: String)
//
//    @Query("SELECT * FROM history")
//    fun getAll(): LiveData<List<History>>
//
//}