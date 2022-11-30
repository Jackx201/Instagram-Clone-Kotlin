package com.example.instagram.login.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    } // https://run.mocky.io/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014
}