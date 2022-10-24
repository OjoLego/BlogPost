package com.example.blogpost.model.repository

import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.model.data.PostResult
import com.example.blogpost.model.data.SendPostData
import com.example.blogpost.model.data.SendPostResult
import com.example.blogpost.model.datasource.remote.api.PostApiService
import retrofit2.Call

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
}