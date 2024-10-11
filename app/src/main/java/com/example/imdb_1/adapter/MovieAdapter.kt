package com.example.imdb_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_1.DTO.MovieDTO
import com.example.imdb_1.R
import com.example.imdb_1.model.Movie
import com.example.imdb_1.viewHolder.MovieViewHolder

class MovieAdapter(val movieList : List<MovieDTO>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = movieList[position]
        holder.render(movieItem)
    }
}