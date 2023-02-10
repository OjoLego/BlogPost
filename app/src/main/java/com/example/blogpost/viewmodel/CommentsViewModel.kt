package com.example.blogpost.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.model.data.PostResult
import com.example.blogpost.model.datasource.remote.api.PostRetrofit
import com.example.blogpost.model.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "CommentsViewModel"
class CommentsViewModel(application: Application): AndroidViewModel(application) {

    private val retrofitService = PostRetrofit.postRetrofit
    private val postRepository = PostRepository(retrofitService)
    private var _commentsList = MutableLiveData<List<CommentsResult>>()
    val commentsList : LiveData<List<CommentsResult>> = _commentsList

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

}