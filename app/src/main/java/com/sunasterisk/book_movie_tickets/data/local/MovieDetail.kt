package com.sunasterisk.book_movie_tickets.data.local

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("genres")
    val genres: List<Genres>,
    @SerializedName("overview")
    val overview: String?,
//    @SerializedName("")
//    val videoPath: String?,
//    @SerializedName("")
//    val cast: List<Int>,
//    @SerializedName("")
//    val crew: List<Int>,
//    @SerializedName("")
    val similarMovie: List<Int>,
    @SerializedName("popularity")
    val popularity : Double,
    @SerializedName("runtime")
    val runtime : Int,
    @SerializedName("status")
    val status: String,
    var discount : Double?,
    var priceTicker: Int? =0,
// link youtube =https://www.youtube.com/watch?v=key
)
