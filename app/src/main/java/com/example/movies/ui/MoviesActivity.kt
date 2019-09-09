package com.example.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.ui.adapters.MoviesAdapter
import com.example.movies.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {
    private val moviesViewModel by viewModel<MoviesViewModel>()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings()
    }

    private fun setupBindings() {
        bindingInit()
        moviesViewModel.listGenres.observe(this, Observer {
            this.moviesViewModel.genres()
        })
        moviesViewModel.pageMovies.observe(this, Observer {
            setUpList()
        })
        setUpRecyclerView()
        moviesViewModel.pages()
    }

    fun setUpRecyclerView() {
        adapter = MoviesAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun setUpList() {
        moviesViewModel.pageMovies.value?.listMovies?.let { adapter.addAll(it) }
    }

    fun bindingInit() {
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
