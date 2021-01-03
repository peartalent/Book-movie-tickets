package com.sunasterisk.book_movie_tickets.data.local

import com.google.gson.annotations.SerializedName

class MovieShort(
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
)
