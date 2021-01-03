package com.sunasterisk.book_movie_tickets.data.local

import com.google.gson.annotations.SerializedName

class PersonResponse(
    @SerializedName("cast") val cast: List<Person>,
    @SerializedName("crew") val crew: List<Person>
)
