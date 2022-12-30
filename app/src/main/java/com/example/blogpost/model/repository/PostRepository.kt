package com.example.blogpost.model.repository

import androidx.lifecycle.LiveData
import com.example.blogpost.database.CommentsResultDao
import com.example.blogpost.database.PostResultDao
import com.example.blogpost.database.PostUsersDao
import com.example.blogpost.model.data.*
import com.example.blogpost.model.datasource.remote.api.PostApiService
import com.example.blogpost.model.datasource.remote.api.PostRetrofit

class PostRepository(
    val postResultDao: PostResultDao,
    val commentsResultDao:CommentsResultDao,
    val postUsersDao: PostUsersDao
//    private val postApiService: PostApiService
){

//     @getAllPostResult obtaining data from the PostResultDataBase using the PostResultDao...

    val getAllPostResult: LiveData<List<PostResult>> = postResultDao.readAllPostResult()
    val getAllCommentsResult: LiveData<List<CommentsResult>> = commentsResultDao.readAllCommentsResult()
    val getAllPostUsers: LiveData<List<PostUsers>> = postUsersDao.getAllUsers()

//    suspend fun getPost():List<PostResult>{
//        return postApiService.getPost()
//    }

    suspend fun addPostResult(post:PostResult){
        postResultDao.insertPostResult(post)
    }

//    Add Bulk postData in the PostDataBase using the PostDao from Api
    suspend fun addBulkPostResult(){
        val response = PostRetrofit.postRetrofit.getPost()
        postResultDao.insertBulkPostResult(response)
    }

//    suspend fun getComments(postId: String):List<CommentsResult>{
//        return postApiService.getComments(postId)
//    }

//    Add Bulk CommentData in the CommentDataBase using the CommentDao from Api
    suspend fun addBulkCommentsResult(postId: String){
        val response = PostRetrofit.postRetrofit.getComments(postId)
        commentsResultDao.insertBulkCommentsResult(response)
    }

//    suspend fun sendPost(params:SendPostData):SendPostResult{
//        return postApiService.sendPost(params)
//    }

//    suspend fun getPostUser(
////        postUserId: String
//    ): List<PostUsers>{
//        return postApiService.getPostUser()
//    }

//    Add Bulk UserData in the UserDataBase using the UserDao from Api
    suspend fun addBulkPostUsers(
//        postUserId: String
    ){
        val response = PostRetrofit.postRetrofit.getPostUser()
    postUsersDao.insertBulkUsers(response)
    }





//    suspend fun searchPost(searchText:String):List<PostResult>{
//        return postApiService.searchPost(searchText)
//    }
}