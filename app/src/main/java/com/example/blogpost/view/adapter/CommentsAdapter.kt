package com.example.blogpost.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CommentsCardviewBinding
import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.model.data.PostResult

class CommentsAdapter(
//    val items: List<CommentsResult>
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var updatedCommentResult = mutableListOf<CommentsResult>()

    fun setCommentsResult(itemsPost:List<CommentsResult>){
        updatedCommentResult = itemsPost.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommentsViewHolder(
            CommentsCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CommentsViewHolder -> {
                holder.bind(updatedCommentResult[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return updatedCommentResult.size
    }


}