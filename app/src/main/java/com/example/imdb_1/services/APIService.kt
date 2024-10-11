package com.example.imdb_1.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
///9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg
        private var retrofit : Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!
        }
    }
}