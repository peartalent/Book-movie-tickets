package com.sunasterisk.book_movie_tickets.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.ui.popular.PopularViewHolder

class AdapterMovieRecommnendation (private val list: List<MovieShort>)
    : RecyclerView.Adapter<RecommendationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecommendationViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        val movie: MovieShort = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}
