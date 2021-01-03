package com.sunasterisk.book_movie_tickets.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dinhtai.retrofit.IMovieNetwork
import com.dinhtai.retrofit.RetrofitRespon
import com.squareup.picasso.Picasso
import com.sunasterisk.book_genres_tickets.ui.detail.AdapterGenres
import com.sunasterisk.book_movie_tickets.R
import com.sunasterisk.book_movie_tickets.data.Config
import com.sunasterisk.book_movie_tickets.data.local.*
import com.sunasterisk.book_movie_tickets.ui.popular.AdapterPopular
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Detail : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    private var state = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        retrofit = RetrofitRespon.getInstance().getRetrofit()
        var service = retrofit.create(IMovieNetwork::class.java)

        val bundle: Bundle? = intent.extras
        val idMovie: Int = intent.getIntExtra("id_movie", -1)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        service.movieDetail(idMovie).enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                var movieDetail: MovieDetail = response.body()!!
                Picasso.get().load(Config.SrcImage + movieDetail.backdropPath).into(imagePoster)
                textNameMovie.text = movieDetail.title
                textReleaseDate.text = movieDetail.releaseDate
                textVoteCount.text = movieDetail.voteCount.toString()
                textVoteAverage.text = movieDetail.voteAverage.toString()
                textOverviewContent.text = movieDetail.overview
                btnShowOverview.setOnClickListener {
                    if (state == 1) {
                        textOverviewContent.maxLines = 10
                        state = 2
                        btnShowOverview.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp)
                    } else {
                        textOverviewContent.maxLines = 2
                        state = 1
                        btnShowOverview.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp)
                    }
                }
                buttonPlay.setOnClickListener {
                    val intent = Intent(this@Detail, VideoPlay::class.java)
                    intent.putExtra("id_movie", idMovie)
                    startActivity(intent)
                }
                var adapterGenres = AdapterGenres(movieDetail.genres)
                recyclerGenres.adapter = adapterGenres
                var linearLayoutManager =
                    LinearLayoutManager(this@Detail, LinearLayoutManager.HORIZONTAL, false)
                recyclerGenres.layoutManager = linearLayoutManager
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        service.person(idMovie).enqueue(object : Callback<PersonResponse> {
            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                var actors = mutableListOf<Person>()
                if (response.body()!!.cast != null)
                    actors.addAll(response.body()!!.cast)
                var adapterPerson = AdapterPerson(actors)
                recyclerCastAndCrew.adapter = adapterPerson
                var linearLayoutManager =
                    LinearLayoutManager(this@Detail, LinearLayoutManager.HORIZONTAL, false)
                recyclerCastAndCrew.layoutManager = linearLayoutManager
            }

            override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        service.movieRecommendations(idMovie).enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                var movies = mutableListOf<MovieShort>()
                if (response.body()!!.movies != null)
                    movies.addAll(response.body()!!.movies)
                var adapter = AdapterMovieRecommnendation(movies)
                recycleMovieRecommendations.adapter = adapter
                var linearLayoutManager =
                    LinearLayoutManager(this@Detail, LinearLayoutManager.HORIZONTAL, false)
                recycleMovieRecommendations.layoutManager = linearLayoutManager
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
