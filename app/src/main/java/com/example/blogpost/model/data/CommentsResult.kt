package com.example.blogpost.model.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Keep
@Entity(tableName = "CommentsResultData")
data class CommentsResult(
    @SerializedName("body")
    val body: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("postId")
    val postId: Int?
)