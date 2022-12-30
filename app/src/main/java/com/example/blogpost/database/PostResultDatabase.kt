package com.example.blogpost.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blogpost.model.data.PostResult

@Database(entities = [PostResult::class], version = 1, exportSchema = false)
abstract class PostResultDatabase: RoomDatabase() {

//    Creating an Instance of the PostDao Interface
    abstract fun PostDao(): PostResultDao

    companion object{
        @Volatile
        private var INSTANCE:PostResultDatabase? = null

        fun getPostResultDatabase(context: Context): PostResultDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }


            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostResultDatabase::class.java,
                    "postresult_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }

}