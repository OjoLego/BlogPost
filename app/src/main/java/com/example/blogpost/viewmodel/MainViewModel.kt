package com.example.blogpost.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogpost.model.data.*
import com.example.blogpost.model.datasource.remote.api.PostRetrofit
import com.example.blogpost.model.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"
class MainViewModel:ViewModel() {

    private val retrofitService = PostRetrofit.postRetrofit
    private val postRepository = PostRepository(retrofitService)
    private var _postList = MutableLiveData<List<PostResult>>()
    val postList : LiveData<List<PostResult>> = _postList

    private var _commentsList = MutableLiveData<List<CommentsResult>>()
    val commentsList: LiveData<List<CommentsResult>> = _commentsList

    private var _sendPost = MutableLiveData<SendPostResult>()
    val sendPostt : LiveData<SendPostResult> = _sendPost

    private var _getPostUser = MutableLiveData<List<PostUsers>>()
    val getPostUser : LiveData<List<PostUsers>> = _getPostUser

//    private var _searchPost = MutableLiveData<List<PostResult>>()
//    val searchPost : LiveData<List<PostResult>> = _searchPost

    fun getBlockPost(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = postRepository.getPost()
                Log.d("GETALLPOST",res.toString())
                _postList.postValue(res)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getComments(postId: String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val res = postRepository.getComments(postId)
                Log.d(TAG,res.toString())
                _commentsList.postValue(res)
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun sendPost(params:SendPostData){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val res = postRepository.sendPost(params)
                Log.d(TAG,res.toString())
                _sendPost.postValue(res)
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    fun getPostUser(
//        postUserId:String
    ){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val res = postRepository.getPostUser()
                Log.d(TAG,res.toString())
                _getPostUser.postValue(res)
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}