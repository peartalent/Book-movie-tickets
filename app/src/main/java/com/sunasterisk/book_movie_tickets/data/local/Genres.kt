package com.sunasterisk.book_movie_tickets.data.local

import com.google.gson.annotations.SerializedName

data class Genres(@SerializedName("id") val id: Int =-1,@SerializedName("name") val name: String="")
