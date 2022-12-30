package com.example.blogpost.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blogpost.model.data.CommentsResult

@Database(entities = [CommentsResult::class], version = 1, exportSchema = false)
abstract class CommentsResultDatabase:RoomDatabase() {

    abstract fun CommentsDao(): CommentsResultDao

    companion object {
        @Volatile
        private var INSTANCE: CommentsResultDatabase? = null

        fun getCommentsResultDatabase(context: Context): CommentsResultDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CommentsResultDatabase::class.java,
                    "commentsresult_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}