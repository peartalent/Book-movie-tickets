package com.sunasterisk.book_genres_tickets.ui.detail

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sunasterisk.book_movie_tickets.Movie
import com.sunasterisk.book_movie_tickets.R
import com.sunasterisk.book_movie_tickets.data.local.Genres


class AdapterGenres (private val list: List<Genres>)
    : RecyclerView.Adapter<GenresViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GenresViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genres: Genres = list[position]
        holder.bind(genres)
    }

    override fun getItemCount(): Int = list.size
}
class GenresViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_genres, parent, false)) {
    private var mTitleView: TextView? = null
    private var mContext: Context? = null

    init {
        mTitleView = itemView.findViewById(R.id.textGenres)
        mContext = parent.context
    }

    fun bind(genres: Genres) {
        mTitleView?.text = genres.name
        mTitleView?.setOnClickListener {
            val intent = Intent(mContext, Movie::class.java)
            intent.putExtra("id_genres",genres.id)
            mContext?.startActivity(intent)
        }
    }
}
