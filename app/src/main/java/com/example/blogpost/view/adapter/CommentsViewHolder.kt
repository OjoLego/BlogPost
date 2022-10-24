package com.example.blogpost.view.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CommentsCardviewBinding
import com.example.blogpost.model.data.CommentsResult

private const val TAG = "CommentsViewHolder"
class CommentsViewHolder(private val binding: CommentsCardviewBinding):RecyclerView.ViewHolder(binding.root){

    private val commentsBody = binding.commentsBody
    private val commentsId = binding.commentsId
    private val commentsUserEmail = binding.commentsUserEmail

    fun bind(comments:CommentsResult){
        comments.body?.let { Log.d(TAG,it) }
        commentsBody.text = comments.body
        commentsId.text = comments.id.toString()
        commentsUserEmail.text = comments.email.toString()
    }
}