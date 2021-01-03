package com.sunasterisk.book_movie_tickets.ui.detail

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
import com.sunasterisk.book_movie_tickets.data.local.Person
import com.sunasterisk.book_movie_tickets.ui.detail.Detail

class PersonViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_person, parent, false)) {
    private var mTitleView: TextView? = null
    private var img: ImageView? =null
    public var cardView : CardView? = null
    private var mContext : Context?=null

    init {
        mTitleView = itemView.findViewById(R.id.textNameActor)
        img = itemView.findViewById(R.id.imageAvatar)
        cardView = itemView.findViewById(R.id.cardviewMovie)
        mContext = parent.context
    }

    fun bind(p: Person) {
        mTitleView?.text = p.name
        Picasso.get().load(Config.SrcImage+p.profilePath).into(img)

    }

}
