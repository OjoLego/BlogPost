package com.example.blogpost.view.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CardviewBinding
import com.example.blogpost.model.data.PostResult

private const val TAG = "PostViewHolder"
class PostViewHolder(private val binding: CardviewBinding): RecyclerView.ViewHolder(binding.root){

    private val postTitle = binding.postTitle
    private val postBody = binding.postBody

    fun bind(post: PostResult,postClickListener: PostClickListener){
        post.title?.let { Log.d(TAG, it) }
        postTitle.text = post.title
        postBody.text = post.body
        postBody.setOnClickListener { postClickListener.onPostClick(post.id!!) }
    }
}