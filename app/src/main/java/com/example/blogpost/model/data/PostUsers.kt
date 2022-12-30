package com.example.blogpost.model.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Keep
@Entity(tableName = "PostUsersData")
data class PostUsers(
    @SerializedName("address")
    val address: Address?,
    @SerializedName("company")
    val company: Company?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("website")
    val website: String?
) {
    @Keep
    data class Address(
        @SerializedName("city")
        val city: String?,
        @SerializedName("geo")
        val geo: Geo?,
        @SerializedName("street")
        val street: String?,
        @SerializedName("suite")
        val suite: String?,
        @SerializedName("zipcode")
        val zipcode: String?
    ) {
        @Keep
        data class Geo(
            @SerializedName("lat")
            val lat: String?,
            @SerializedName("lng")
            val lng: String?
        )
    }

    @Keep
    data class Company(
        @SerializedName("bs")
        val bs: String?,
        @SerializedName("catchPhrase")
        val catchPhrase: String?,
        @SerializedName("name")
        val name: String?
    )
}