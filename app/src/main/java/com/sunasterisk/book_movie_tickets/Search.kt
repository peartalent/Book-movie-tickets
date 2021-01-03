package com.sunasterisk.book_movie_tickets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.dinhtai.retrofit.IMovieNetwork
import com.dinhtai.retrofit.RetrofitRespon
import com.sunasterisk.book_movie_tickets.data.local.MovieResponse
import com.sunasterisk.book_movie_tickets.ui.popular.AdapterPopular
import com.sunasterisk.book_movie_tickets.ui.popular.FragmentPopular
import com.sunasterisk.book_movie_tickets.util.replaceFragment
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.recyclerMoviesSearch
import kotlinx.android.synthetic.main.activity_search.toolbar
import kotlinx.android.synthetic.main.fragment_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Search : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var call: IMovieNetwork;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        retrofit = RetrofitRespon.getInstance().getRetrofit()
        call = retrofit.create(IMovieNetwork::class.java)
        toolbar.title =""
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu_toolbar_main, menu)

        val search = menu?.findItem(R.id.itemSearch)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { it1 ->
                    call.searchMovie(it1).enqueue(
                        object : Callback<MovieResponse> {
                            override fun onResponse(
                                call: Call<MovieResponse>,
                                response: Response<MovieResponse>
                            ) {
                                var movies = response.body()!!.movies
                                var adapter = AdapterPopular(movies)
                                recyclerMoviesSearch.adapter = adapter
                                var gridLayoutManager = GridLayoutManager(this@Search, 2);
                                recyclerMoviesSearch.layoutManager = gridLayoutManager
                            }

                            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                                TODO("Not yet implemented")
                            }
                        }
                    )
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

//                newText?.let { it1 ->
//                    if (newText!!.isEmpty()) {
//                        toolbar.title = "Popular"
//                        replaceFragment(FragmentPopular.newInstance(), R.id.frameContainer)
//                    }
//                    call.searchMovie(it1).enqueue(
//                        object : Callback<MovieResponse> {
//                            override fun onResponse(
//                                call: Call<MovieResponse>,
//                                response: Response<MovieResponse>
//                            ) {
//                                if (response != null && response.body() != null && response.body()!!.movies != null) {
//                                    var movies = response.body()!!.movies
//                                    var adapter = AdapterPopular(movies)
//                                    recyclerMoviesSearch.adapter = adapter
//                                    var gridLayoutManager = GridLayoutManager(this@Search, 2);
//                                    recyclerMoviesSearch.layoutManager = gridLayoutManager
//                                }
//                            }
//
//                            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                                TODO("Not yet implemented")
//                            }
//                        }
//                    )
//                }
                return false
            }

        })
        return true
    }
}
