package com.example.blogpost.view.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CardviewBinding
import com.example.blogpost.model.data.PostResult


private const val TAG = "PostViewHolder"
class PostViewHolder(private val binding: CardviewBinding): RecyclerView.ViewHolder(binding.root){

    private val postTitle = binding.postTitle
    private val postBody = binding.postBody
    private val postUserName = binding.authoursName


    fun bind(post: PostResult, user: String, postClickListener: PostClickListener){
        post.title?.let { Log.d(TAG, it) }
        postTitle.text = post.title
        postBody.text = post.body
        postUserName.text = user
        postBody.setOnClickListener { postClickListener.onPostClick(post.id!!,post.title!!,post.body!!,
            user!!,it)}
    }
}