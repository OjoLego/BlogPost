package com.example.blogpost.view.adapter

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CardviewBinding
import com.example.blogpost.model.data.PostResult
import com.example.blogpost.model.data.PostUsers
import com.example.blogpost.viewmodel.MainViewModel


private const val TAG = "PostViewHolder"
class PostViewHolder(private val binding: CardviewBinding): RecyclerView.ViewHolder(binding.root){

    private val postTitle = binding.postTitle
    private val postBody = binding.postBody
    private val postUserName = binding.authoursName

//    private val postUserId = binding.postUserId
//    private val bundle = bundleOf("postBody" to binding.postBody.text.toString())

    fun bind(post: PostResult, user: String, postClickListener: PostClickListener){
        post.title?.let { Log.d(TAG, it) }
        postTitle.text = post.title
        postBody.text = post.body
        postUserName.text = user
//        postUserId.text = post.userId.toString()
        postBody.setOnClickListener { postClickListener.onPostClick(post.id!!,post.title!!,post.body!!,
            user!!,it)}
    }
}