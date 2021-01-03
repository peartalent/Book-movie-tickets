package com.dinhtai.retrofit

import com.sun.homecinema.data.model.VideoResponse
import com.sunasterisk.book_movie_tickets.data.local.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieNetwork {
    //    lấy popular movie
    @GET("movie/popular?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&page=1")
    fun moviesPopular(): Call<MovieResponse>
    @GET("movie/top_rated?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&page=1")
    fun moviesTopRate(): Call<MovieResponse>
    @GET("movie/upcoming?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&page=1")
    fun moviesUpComming(): Call<MovieResponse>
    @GET("movie/now_playing?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&page=1")
    fun moviesNowPlay(): Call<MovieResponse>
    @GET("movie/{movie_id}/recommendations?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&page=1")
    fun movieRecommendations(@Path("movie_id") id: Int): Call<MovieResponse>
    @GET("https://api.themoviedb.org/3/discover/movie?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun moviesGenres(@Query("with_genres") idGenres: Int): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US")
    fun movieDetail(@Path("movie_id") id: Int): Call<MovieDetail>

    @GET("movie/{movie_id}/credits?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US")
    fun person(@Path("movie_id") id: Int): Call<PersonResponse>
    //    tìm kiếm
    @GET("search/movie?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US&page=1&include_adult=false")
    fun searchMovie(@Query("query") query: String): Call<MovieResponse>

    //
    @GET("movie/{movie_id}/videos?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US")
    fun video(@Path("movie_id") id: Int): Call<VideoResponse>

    @get:GET("genre/movie/list?api_key=fbc9c62908148ea463ab7fb7d02534e0&language=en-US")
    val genres: Call<List<Genres>>
}
