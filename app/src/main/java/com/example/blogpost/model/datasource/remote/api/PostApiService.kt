package com.example.blogpost.model.datasource.remote.api

import com.example.blogpost.model.data.*
import retrofit2.Call
import retrofit2.http.*

interface PostApiService {

    @GET("posts")
    suspend fun getPost():List<PostResult>

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: String):List<CommentsResult>

    @POST("posts")
    suspend fun sendPost(@Body params:SendPostData):SendPostResult

//    @GET("posts/{userId}/users")
    @GET("users")
    suspend fun getPostUser(
//    @Path("userId") postUserId: String
): List<PostUsers>

}