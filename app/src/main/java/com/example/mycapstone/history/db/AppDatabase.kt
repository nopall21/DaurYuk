package com.example.mycapstone.history.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [ClassificationResult::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun classificationDao(): ClassificationDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "classification_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
