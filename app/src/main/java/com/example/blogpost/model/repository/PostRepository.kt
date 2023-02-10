package com.example.blogpost.model.repository

import androidx.lifecycle.LiveData
import com.example.blogpost.model.data.*
import com.example.blogpost.model.datasource.remote.api.PostApiService
import com.example.blogpost.model.datasource.remote.api.PostRetrofit

class PostRepository(
    private val postApiService: PostApiService
){
    suspend fun getPost():List<PostResult>{
        return postApiService.getPost()
    }

    suspend fun getComments(postId: String):List<CommentsResult>{
        return postApiService.getComments(postId)
    }

    suspend fun sendPost(params:SendPostData):SendPostResult{
        return postApiService.sendPost(params)
    }

    suspend fun getPostUser(): List<PostUsers>{
        return postApiService.getPostUser()
    }

}