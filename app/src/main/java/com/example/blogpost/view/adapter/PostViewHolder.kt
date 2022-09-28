package com.example.blogpost.view.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CardviewBinding
import com.example.blogpost.model.data.PostResult

private const val TAG = "PostViewHolder"
class PostViewHolder(val binding: CardviewBinding): RecyclerView.ViewHolder(binding.root){

    val postTitle = binding.postTitle
    val postBody = binding.postBody

    fun bind(post: PostResult){
        post.title?.let { Log.d(TAG, it) }
        postTitle.setText(post.title)
        postBody.setText(post.body)
    }
}