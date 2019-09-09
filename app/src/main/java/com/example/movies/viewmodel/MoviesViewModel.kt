package com.example.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.data.model.GenresList
import com.example.movies.data.model.Movie
import com.example.movies.data.model.PageMovies
import com.example.movies.data.repository.remote.ServiceRequest

class MoviesViewModel(private val service: ServiceRequest) : ViewModel() {
    val pageMovies: LiveData<PageMovies>
        get() = _pageMovies
    private val _pageMovies: MutableLiveData<PageMovies> = MutableLiveData()
    private val _listGenres: MutableLiveData<GenresList> = MutableLiveData()
    val listGenres: LiveData<GenresList>
        get() = _listGenres


    fun genres() {
        service.getGenres(
            fun(failure) {

            }
            , fun(success) {
                _listGenres.value = success
            })
    }

    fun pages() {
        service.getNextPage(1,
            fun(failure) {
            },
            fun(success) {
                success.listMovies = orderList(success.listMovies)
                _pageMovies.value = success
            }
        )
    }

    private fun orderList(listMovies: List<Movie>): MutableList<Movie> {
        val listMovies = listMovies.sortedWith(compareBy { it.date })
        return listMovies.toMutableList()
    }
}