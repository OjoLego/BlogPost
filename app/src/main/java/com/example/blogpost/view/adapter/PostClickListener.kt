package com.example.blogpost.view.adapter

interface PostClickListener {
    fun onPostClick(id:Int, postTitle:String, postBody:String)
}