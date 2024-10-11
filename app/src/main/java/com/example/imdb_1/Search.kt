package com.example.imdb_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_1.DTO.MovieDTO
import com.example.imdb_1.DTO.MoviesDTO
import com.example.imdb_1.adapter.MovieAdapter
import com.example.imdb_1.provider.MovieProvider
import com.example.imdb_1.services.APIInterface
import com.example.imdb_1.services.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Search : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val root =  inflater.inflate(R.layout.fragment_search, container, false)
        val recyclerView  = root.findViewById<RecyclerView>(R.id.recycler)

        getMovieData {
            initRecyclerView(recyclerView, it)
        }


        return root
    }

    private fun initRecyclerView( recyclerView: RecyclerView, movieList : List<MovieDTO>){
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = MovieAdapter(movieList)
    }

    private fun getMovieData(callback : (List<MovieDTO>) -> Unit) {
        val apiService = APIService.getInstance().create(APIInterface::class.java)
        apiService.getMovies().enqueue(object : Callback<MoviesDTO>{
            override fun onResponse(call: Call<MoviesDTO>, response: Response<MoviesDTO>) {


                Log.e(">>>>>", response.body()!!.results[0].imageURL)

                return callback(response.body()?.results?: listOf())
            }

            override fun onFailure(p0: Call<MoviesDTO>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}