package com.example.movies.data.repository.remote

import android.content.Context
import com.example.movies.BuildConfig.base_url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient


class ServiceProvider(context: Context) {
    private var retrofit: Retrofit

    init {
        val client = OkHttpClient
            .Builder().addInterceptor(ChuckInterceptor(context))
            .build()

        this.retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val request: ApiService = retrofit.create(ApiService::class.java)

}