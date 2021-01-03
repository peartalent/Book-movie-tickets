package com.sunasterisk.book_movie_tickets.data.local

import com.google.gson.annotations.SerializedName

data class MovieResponse (@SerializedName("results") val movies: List<MovieShort>)
