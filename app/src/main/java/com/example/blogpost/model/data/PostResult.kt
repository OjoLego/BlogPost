package com.example.blogpost.model.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Keep
@Entity(tableName = "PostResultData")
data class PostResult(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)