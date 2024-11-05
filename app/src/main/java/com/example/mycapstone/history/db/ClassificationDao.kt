package com.example.mycapstone.history.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClassificationDao {
    @Insert
    suspend fun insert(result: ClassificationResult)

    @Query("SELECT * FROM classification_history")
    suspend fun getAll(): List<ClassificationResult>
}
