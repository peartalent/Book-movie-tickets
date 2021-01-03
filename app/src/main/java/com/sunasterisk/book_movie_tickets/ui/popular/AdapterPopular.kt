package com.sunasterisk.book_movie_tickets.ui.popular

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.ui.detail.Detail
import kotlinx.android.synthetic.main.item_movie.*

class AdapterPopular(private val list: List<MovieShort>)
    : RecyclerView.Adapter<PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PopularViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val movie: MovieShort = list[position]
        holder.bind(movie)
//        holder.cardView?.setOnClickListener {
//            val intent = Intent(, Detail::class.java)
//            intent.putExtra("id_movie",movies.)
//
//        }
    }

    override fun getItemCount(): Int = list.size

}
