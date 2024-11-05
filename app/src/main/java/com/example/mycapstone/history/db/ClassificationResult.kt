package com.example.mycapstone.history.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classification_history")
data class ClassificationResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageUri: String,
    val title: String,
    val description: String,
    val tips: String
)
