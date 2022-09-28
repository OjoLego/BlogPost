package com.example.blogpost.model.repository

import com.example.blogpost.model.data.PostResult
import com.example.blogpost.model.datasource.remote.api.PostApiService

class PostRepository(
    private val postApiService: PostApiService
){
    suspend fun getPost():List<PostResult>{
        return postApiService.getPost()
    }
}