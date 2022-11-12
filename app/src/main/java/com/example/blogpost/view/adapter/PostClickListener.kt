package com.example.blogpost.view.adapter

import android.view.View

interface PostClickListener {
    fun onPostClick(id:Int, postTitle:String, postBody:String, postUserName:String, view: View)
}