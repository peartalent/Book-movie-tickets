package com.sunasterisk.book_movie_tickets.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, V : BaseViewHolder<T>> : RecyclerView.Adapter<V>() {

    private val items = mutableListOf<T>()

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.onBindData(items[position])
    }

    fun updateData(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
