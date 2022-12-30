package com.example.blogpost.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blogpost.model.data.CommentsResult


@Dao
interface CommentsResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBulkCommentsResult(post: List<CommentsResult>)

    @Query("SELECT * FROM CommentsResultData ORDER BY id DESC")
    fun readAllCommentsResult(): LiveData<List<CommentsResult>>

}