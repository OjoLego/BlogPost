package com.example.blogpost.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.blogpost.database.CommentsResultDatabase
import com.example.blogpost.database.PostResultDatabase
import com.example.blogpost.database.PostUsersDatabase
import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.model.repository.PostRepository
import kotlinx.coroutines.launch

class CommentsViewModel(application: Application): AndroidViewModel(application) {

    private val repository : PostRepository
    val readAllCommentsResult: LiveData<List<CommentsResult>>

    init {
        var postDao = PostResultDatabase.getPostResultDatabase(application).PostDao()
        var commentDao = CommentsResultDatabase.getCommentsResultDatabase(application).CommentsDao()
        var userDao = PostUsersDatabase.getPostUsersDatabase(application).PostUsersDao()
        repository = PostRepository(postDao,commentDao,userDao)
        readAllCommentsResult = repository.getAllCommentsResult
    }

    //    @addBulkComments function to  add all comments to the DB from the Api
    fun addBulkComments(postId: String){
        viewModelScope.launch {
            repository.addBulkCommentsResult(postId)
        }
    }

}