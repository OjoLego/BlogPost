package com.example.blogpost.util

import com.example.blogpost.model.data.PostResult
import com.example.blogpost.model.data.PostUsers

object getUsersDetails {

    fun getUserName(post: PostResult, usersInfo: MutableList<PostUsers>): String {

        var name = "Bukayo Saka"

        for (i in usersInfo) {
            if (post.userId == i.id) name = i.name.toString()
        }
        return name
    }
}