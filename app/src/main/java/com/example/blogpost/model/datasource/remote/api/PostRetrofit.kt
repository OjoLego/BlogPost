package com.example.blogpost.model.datasource.remote.api

import com.example.blogpost.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PostRetrofit {

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(
            BASE_URL).addConverterFactory(
            GsonConverterFactory.create()

            )
    }

    val postRetrofit:PostApiService by lazy {
        retrofit.build().create(PostApiService::class.java)
    }

}