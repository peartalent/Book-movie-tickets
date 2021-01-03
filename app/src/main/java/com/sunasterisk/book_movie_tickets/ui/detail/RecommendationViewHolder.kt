package com.sunasterisk.book_movie_tickets.ui.detail

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sunasterisk.book_movie_tickets.R
import com.sunasterisk.book_movie_tickets.data.Config
import com.sunasterisk.book_movie_tickets.data.local.MovieShort

class RecommendationViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recommendation, parent, false)) {
    private var mTitleView: TextView? = null
    private var img: ImageView? = null
    public var cardView: CardView? = null
    private var mContext: Context? = null

    init {
        mTitleView = itemView.findViewById(R.id.textName)
        img = itemView.findViewById(R.id.imageMovie)
        cardView = itemView.findViewById(R.id.cardviewMovie)
        mContext = parent.context
    }

    fun bind(movie: MovieShort) {
        mTitleView?.text = movie.title

        movie.posterPath.let {Picasso.get().load(Config.SrcImage + movie.posterPath).into(img)  }
        cardView?.setOnClickListener {
            val intent = Intent(mContext, Detail::class.java)
            intent.putExtra("id_movie", movie.id)
            mContext?.startActivity(intent)
        }
    }
}
