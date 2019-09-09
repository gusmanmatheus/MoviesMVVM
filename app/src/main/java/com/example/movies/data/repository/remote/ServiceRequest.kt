package com.example.movies.data.repository.remote

import com.example.movies.BuildConfig.api_key
import com.example.movies.BuildConfig.language
import com.example.movies.data.model.GenresList
import com.example.movies.data.model.PageMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRequest(private val request: ServiceProvider) {

    fun getNextPage(
        page: Int,
        failure: (failure: String) -> Unit,
        success: (pageMovie: PageMovies) -> Unit
    ) {
        request.request.getPageMovies(api_key, language, page)
            .enqueue(object : Callback<PageMovies> {
                override fun onFailure(call: Call<PageMovies>, t: Throwable) {
                    failure(t.message.toString())
                }

                override fun onResponse(call: Call<PageMovies>, response: Response<PageMovies>) {
                    response.body()?.let(success)
                }

            })
    }

    fun getGenres(
        failure: (failure: String) -> Unit,
        success: (listGenres: GenresList) -> Unit
    ) {
        request.request.getGenres(api_key, language)
            .enqueue(object : Callback<GenresList> {
                override fun onFailure(call: Call<GenresList>, t: Throwable) {
                    failure(t.message.toString())
                }

                override fun onResponse(call: Call<GenresList>, response: Response<GenresList>) {
                    response.body()?.let(success)
                }

            })
    }
}