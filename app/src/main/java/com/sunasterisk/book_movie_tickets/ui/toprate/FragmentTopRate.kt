package com.sunasterisk.book_movie_tickets.ui.toprate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.dinhtai.retrofit.IMovieNetwork
import com.dinhtai.retrofit.RetrofitRespon
import com.sunasterisk.book_movie_tickets.R
import com.sunasterisk.book_movie_tickets.data.local.MovieResponse
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.data.remote.GenresResponse
import com.sunasterisk.book_movie_tickets.ui.detail.Detail
import com.sunasterisk.book_movie_tickets.ui.popular.AdapterPopular
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.item_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.Type

class FragmentTopRate() : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var movies :MutableList<MovieShort> = mutableListOf()
        var adapterPopular : AdapterPopular
        var retrofit: Retrofit
        retrofit = RetrofitRespon.getInstance().getRetrofit()
        var  service =retrofit.create(IMovieNetwork::class.java)
        service.moviesTopRate().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response != null && response.body()!!.movies != null) {
                    movies.addAll(response.body()!!.movies)
                }
                if (movies != null) {
                    adapterPopular = AdapterPopular(movies)
                    if (adapterPopular != null) {
                        recyclerMovies.adapter = adapterPopular
                    }
                }
                var gridLayoutManager = GridLayoutManager(activity,2);
                recyclerMovies.layoutManager = gridLayoutManager
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    companion object {
        fun newInstance(): FragmentTopRate = FragmentTopRate()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_movies, container, false)
        return view
    }

}
