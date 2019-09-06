package com.example.movies.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceProvider {
    companion object {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val request = retrofit.create(ApiService::class.java)
    }
}