package com.example.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies.data.model.GenresList
import com.example.movies.data.model.PageMovies

class MoviesViewModel {
    val pageMovies: LiveData<PageMovies>
        get() = _pageMovies
    private lateinit var _pageMovies: MutableLiveData<PageMovies>

    private lateinit var _listGenres: MutableLiveData<GenresList>
    val listGenres: LiveData<GenresList>
        get() = _listGenres

}