package com.example.blogpost.model.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class PostCommentResults(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(body)
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeValue(userId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostCommentResults> {
        override fun createFromParcel(parcel: Parcel): PostCommentResults {
            return PostCommentResults(parcel)
        }

        override fun newArray(size: Int): Array<PostCommentResults?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize
