package com.sunasterisk.book_movie_tickets.ui.detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.book_movie_tickets.data.local.MovieShort
import com.sunasterisk.book_movie_tickets.data.local.Person
import com.sunasterisk.book_movie_tickets.ui.detail.Detail
import kotlinx.android.synthetic.main.item_movie.*

class AdapterPerson(private val list: List<Person>)
    : RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PersonViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val p: Person = list[position]
        holder.bind(p)
    }

    override fun getItemCount(): Int = list.size

}
