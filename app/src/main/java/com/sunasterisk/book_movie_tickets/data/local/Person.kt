package com.sunasterisk.book_movie_tickets.data.local

import com.google.gson.annotations.SerializedName

class Person(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("credit_id")
    val creditId: String = "",
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("character")
    val character: String = "",
    @SerializedName("profile_path")
    val profilePath : String = ""
)
