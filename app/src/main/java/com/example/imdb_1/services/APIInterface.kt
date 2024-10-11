package com.example.imdb_1.services

import com.example.imdb_1.DTO.MoviesDTO
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {


    @GET("top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    fun getMovies() : Call<MoviesDTO>
}