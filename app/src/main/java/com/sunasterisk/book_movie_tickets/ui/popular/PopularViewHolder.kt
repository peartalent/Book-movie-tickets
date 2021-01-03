package com.sunasterisk.book_movie_tickets.ui.popular

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sunasterisk.book_movie_tickets.R
import com.sunasterisk.book_movie_tickets.data.Config
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.ui.detail.Detail

class PopularViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movie, parent, false)) {
    private var mTitleView: TextView? = null
    private var mTimeView: TextView? = null
    private var img: ImageView? =null
    public var cardView : CardView? = null
    private var mContext : Context?=null
    init {
        mTitleView = itemView.findViewById(R.id.textName)
        mTimeView = itemView.findViewById(R.id.textDate)
        img = itemView.findViewById(R.id.imageBackdrop)
        cardView = itemView.findViewById(R.id.cardviewMovie)
        mContext = parent.context
    }

    fun bind(movie: MovieShort) {
        mTitleView?.text = movie.title
        mTimeView?.text = movie.releaseDate
        Picasso.get().load(Config.SrcImage+movie.posterPath).into(img)
        cardView?.setOnClickListener {
            val intent = Intent(mContext, Detail::class.java)
            intent.putExtra("id_movie",movie.id)
            mContext?.startActivity(intent)
        }
    }

}
