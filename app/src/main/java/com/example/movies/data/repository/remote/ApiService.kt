package com.example.movies.data.repository.remote

import com.example.movies.data.model.GenresList
import com.example.movies.data.model.PageMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/upcoming")
    fun getPageMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<PageMovies>

    @GET("genre/movie/list")
    fun getGenres(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Call<GenresList>
}