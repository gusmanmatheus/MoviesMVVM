package com.example.movies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.data.model.Movie
import com.example.movies.databinding.MovieItemBinding
import com.example.movies.dependences.Util
import com.example.movies.dependences.Util.datePatterBr

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.Holder>() {
    var data: MutableList<Movie> = mutableListOf()
    var onItemClick: ((Movie) -> Unit) = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(parent.context)
        return Holder(layout.inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val binding = holder.binding
        data[position].date = datePatterBr(data[position].date)
        binding?.movie = data[position]
        //  onItemClick = {data[position]}
    }

    fun addAll(data: List<Movie>) {

        this.data = data.toMutableList()
        notifyDataSetChanged()
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: MovieItemBinding? = DataBindingUtil.bind(itemView)

    }

}