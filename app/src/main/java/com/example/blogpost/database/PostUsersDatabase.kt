package com.example.blogpost.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blogpost.model.data.PostUsers

@Database(entities = [PostUsers::class], version = 1, exportSchema = false)
abstract class PostUsersDatabase: RoomDatabase() {

    abstract fun PostUsersDao(): PostUsersDao

    companion object {
        @Volatile
        private var INSTANCE: PostUsersDatabase? = null

        fun getPostUsersDatabase(context: Context): PostUsersDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostUsersDatabase::class.java,
                    "postuser_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}