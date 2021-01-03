package com.sunasterisk.book_movie_tickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.dinhtai.retrofit.IMovieNetwork
import com.dinhtai.retrofit.RetrofitRespon
import com.sunasterisk.book_movie_tickets.data.local.Genres
import com.sunasterisk.book_movie_tickets.data.local.MovieResponse
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.data.remote.GenresResponse
import com.sunasterisk.book_movie_tickets.ui.popular.AdapterPopular
import com.sunasterisk.book_movie_tickets.ui.popular.FragmentPopular
import com.sunasterisk.book_movie_tickets.util.addFragment
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Movie : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var call: IMovieNetwork
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        retrofit = RetrofitRespon.getInstance().getRetrofit()
        call = retrofit.create(IMovieNetwork::class.java)
        var movies :MutableList<MovieShort> = mutableListOf()
        var adapterPopular : AdapterPopular

        val bundle: Bundle? = intent.extras
        val idGenres: Int = intent.getIntExtra("id_genres", -1)

        toolbar.title = GenresResponse.searchGenrs(idGenres)?.name
        call.moviesGenres(idGenres).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies.addAll(response.body()!!.movies)
                adapterPopular = AdapterPopular(movies)
                recyclerMovies.adapter = adapterPopular
                var gridLayoutManager = GridLayoutManager(this@Movie,2);
                recyclerMovies.layoutManager = gridLayoutManager
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu_toolbar_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemSearch -> {
                startActivity(Intent(this, Search::class.java))
            }
        }
        return false
    }

}
