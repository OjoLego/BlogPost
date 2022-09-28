package com.example.blogpost.model.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PostResult(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)