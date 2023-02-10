package com.example.blogpost.model.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CommentsResult(
    @SerializedName("body")
    val body: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("postId")
    val postId: Int?
)