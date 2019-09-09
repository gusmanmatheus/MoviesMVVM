package com.example.movies.dependences

import com.example.movies.data.repository.remote.ServiceProvider
import com.example.movies.data.repository.remote.ServiceRequest
import com.example.movies.viewmodel.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val baseModule = module {
    factory { ServiceProvider(get()) }
    factory { ServiceRequest(get()) }
}
val baseMovies = module {
    viewModel { MoviesViewModel(get()) }
}