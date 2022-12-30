package com.example.blogpost.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blogpost.model.data.PostResult

@Dao
interface PostResultDao {

//    This is the function to insert single new Post Into the PostDatabase Entity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostResult(post: PostResult)

//    This is the function to insert all Post From Api  Into the PostDatabase Entity
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBulkPostResult(post: List<PostResult>)


//    This is the function to observe PostDatabase Entity and get all info
    @Query("SELECT * FROM PostResultData ORDER BY id DESC")
    fun readAllPostResult(): LiveData<List<PostResult>>

}