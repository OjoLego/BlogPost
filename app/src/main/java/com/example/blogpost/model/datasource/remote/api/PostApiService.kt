package com.example.blogpost.model.datasource.remote.api

import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.model.data.PostResult
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiService {

    @GET("posts")
    suspend fun getPost():List<PostResult>

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: String):List<CommentsResult>
}