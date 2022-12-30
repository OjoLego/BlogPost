package com.example.blogpost.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.blogpost.database.CommentsResultDatabase
import com.example.blogpost.database.PostResultDatabase
import com.example.blogpost.database.PostUsersDatabase
import com.example.blogpost.model.data.*
import com.example.blogpost.model.datasource.remote.api.PostRetrofit
import com.example.blogpost.model.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"
class PostViewModel(application: Application):AndroidViewModel(application) {


//    Declaring instance of repository and ReadAllPost and ReadAllUsers Data
    private val repository : PostRepository
    val readAllPostResult: LiveData<List<PostResult>>
//    val readAllCommentsResult: LiveData<List<CommentsResult>>
    val readAllPostUsers: LiveData<List<PostUsers>>

//    Initializing the repository, readAllPostDat and ReadAllUserData in an init block to auto run once the class is active
    init {
        var postDao = PostResultDatabase.getPostResultDatabase(application).PostDao()
        var commentDao = CommentsResultDatabase.getCommentsResultDatabase(application).CommentsDao()
        var userDao = PostUsersDatabase.getPostUsersDatabase(application).PostUsersDao()
        repository = PostRepository(postDao,commentDao,userDao)
        readAllPostResult = repository.getAllPostResult
//        readAllCommentsResult = repository.getAllCommentsResult
        readAllPostUsers = repository.getAllPostUsers
    }

    fun addPost(post: PostResult){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPostResult(post)
        }
    }

//    @addBulkPost function to  add all post to the DB from the Api
    fun addBulkPost(){
        viewModelScope.launch{
            repository.addBulkPostResult()
        }
    }

//    @addBulkComments function to  add all comments to the DB from the Api
//    fun addBulkComments(postId: String){
//        viewModelScope.launch {
//            repository.addBulkCommentsResult(postId)
//        }
//    }

//    @addBulkUser to add bulk users from the APi to the DB
    fun addBulkUsers(){
        viewModelScope.launch {
            repository.addBulkPostUsers()
        }
    }

//    private val retrofitService = PostRetrofit.postRetrofit
//    private val postRepository = PostRepository(retrofitService)
//    private var _postList = MutableLiveData<List<PostResult>>()
//    val postList : LiveData<List<PostResult>> = _postList
//
//    private var _commentsList = MutableLiveData<List<CommentsResult>>()
//    val commentsList: LiveData<List<CommentsResult>> = _commentsList
//
//    private var _sendPost = MutableLiveData<SendPostResult>()
//    val sendPostt : LiveData<SendPostResult> = _sendPost
//
//    private var _getPostUser = MutableLiveData<List<PostUsers>>()
//    val getPostUser : LiveData<List<PostUsers>> = _getPostUser

//    private var _searchPost = MutableLiveData<List<PostResult>>()
//    val searchPost : LiveData<List<PostResult>> = _searchPost

//    fun getBlockPost(){
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val res = postRepository.getPost()
//                Log.d("GETALLPOST",res.toString())
//                _postList.postValue(res)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    fun getComments(postId: String){
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                val res = postRepository.getComments(postId)
//                Log.d(TAG,res.toString())
//                _commentsList.postValue(res)
//            }
//            catch (e: Exception){
//                e.printStackTrace()
//            }
//        }
//    }
//
//    fun sendPost(params:SendPostData){
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                val res = postRepository.sendPost(params)
//                Log.d(TAG,res.toString())
//                _sendPost.postValue(res)
//            }
//            catch (e:Exception){
//                e.printStackTrace()
//            }
//        }
//    }
//
//    fun getPostUser(
////        postUserId:String
//    ){
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                val res = postRepository.getPostUser()
//                Log.d(TAG,res.toString())
//                _getPostUser.postValue(res)
//            }
//            catch (e:Exception){
//                e.printStackTrace()
//            }
//        }
//    }

}