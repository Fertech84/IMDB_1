package com.example.imdb_1.viewHolder

import android.view.View


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdb_1.DTO.MovieDTO
import com.example.imdb_1.databinding.MovieItemBinding
import com.example.imdb_1.services.APIService
import com.example.imdb_1.services.APIService.Companion
import com.example.imdb_1.services.APIService.Companion.IMAGE_BASE_URL

class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val binding = MovieItemBinding.bind(view)
    private val movieTitle = binding.movieTitle
    val movieImage = binding.movieImage
    private val movieYear = binding.movieYear
    private val movieDirector = binding.movieDirector



    fun render(movieModel : MovieDTO) {
        movieTitle.text = movieModel.movieName
        movieYear.text = movieModel.date
        movieDirector.text = movieModel.overview
        val imageURL = IMAGE_BASE_URL +  movieModel.imageURL
        Glide.with(movieImage.context).load(imageURL).into(movieImage)

    }
}