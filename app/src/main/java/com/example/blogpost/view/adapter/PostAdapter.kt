package com.example.blogpost.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blogpost.databinding.CardviewBinding
import com.example.blogpost.model.data.PostResult
import com.example.blogpost.model.data.PostUsers
import com.example.blogpost.util.getUsersDetails

class PostAdapter(var postClickListener: PostClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

     var updatedPostResult = mutableListOf<PostResult>()
    var updatedPostUsers = mutableListOf<PostUsers>()

    fun setPostData(itemsPost:List<PostResult>){
        updatedPostResult = itemsPost.toMutableList()
        notifyDataSetChanged()
    }


    fun setPostUserData(itemsUser:List<PostUsers>){
        updatedPostUsers = itemsUser.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            CardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PostViewHolder -> {
                holder.bind(
                    updatedPostResult[position],
                    getUsersDetails.getUserName(updatedPostResult[position],updatedPostUsers),
                    postClickListener
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return updatedPostResult.size
    }

}