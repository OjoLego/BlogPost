package com.example.blogpost.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogpost.model.data.PostResult
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

    fun getBlockPost(){
//        viewModelScope.launch(Dispatchers.IO){
//            val res = postRepository.getAllPost()
//            Log.d(TAG,res.toString())
//            _postList.postValue(res)
//        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = postRepository.getPost()
                Log.d(TAG,res.toString())
                _postList.postValue(res)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}