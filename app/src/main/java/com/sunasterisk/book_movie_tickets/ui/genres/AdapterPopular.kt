package com.sunasterisk.book_movie_tickets.ui.genres

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.book_movie_tickets.data.local.Genres
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.ui.detail.Detail
import kotlinx.android.synthetic.main.item_movie.*

class AdapterGenres(private val list: List<Genres>)
    : RecyclerView.Adapter<GenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GenresViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genres: Genres = list[position]
        holder.bind(genres)
//        holder.cardView?.setOnClickListener {
//            val intent = Intent(, Detail::class.java)
//            intent.putExtra("id_movie",movies.)
//
//        }
    }

    override fun getItemCount(): Int = list.size

}
