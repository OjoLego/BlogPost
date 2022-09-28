package com.example.blogpost.model.datasource.remote.api

import com.example.blogpost.model.data.PostResult
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getPost():List<PostResult>



}