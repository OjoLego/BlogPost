package com.example.blogpost.model.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SendPostResult(

    @SerializedName("body")
    val body: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("id")
     val id: Int?
)
