package com.sunasterisk.book_movie_tickets.ui.genres

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sunasterisk.book_movie_tickets.Movie
import com.sunasterisk.book_movie_tickets.R
import com.sunasterisk.book_movie_tickets.data.Config
import com.sunasterisk.book_movie_tickets.data.local.Genres
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.ui.detail.Detail
import com.sunasterisk.book_movie_tickets.util.addFragment

class GenresViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_genres_main, parent, false)) {
    private var button: Button? = null
    public var cardView : CardView? = null
    private var mContext : Context?=null
    init {
        button = itemView.findViewById(R.id.buttonItemGenres)
        cardView = itemView.findViewById(R.id.cardviewMovie)
        mContext = parent.context
    }

    fun bind(genres: Genres) {
        button?.text = genres.name
        button?.setOnClickListener {
            val intent = Intent(mContext, Movie::class.java)
            intent.putExtra("id_genres",genres.id)
            mContext?.startActivity(intent)
        }
    }

}
