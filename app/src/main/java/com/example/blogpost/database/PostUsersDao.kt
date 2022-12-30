package com.example.blogpost.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blogpost.model.data.PostUsers

@Dao
interface PostUsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBulkUsers(users : List<PostUsers>)

    @Query("SELECT * FROM PostUsersData")
    fun getAllUsers() : LiveData<List<PostUsers>>
}