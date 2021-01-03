package com.sunasterisk.book_movie_tickets.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    protected var data: T? = null

    init {
        view.setOnClickListener {
            data?.let(::onHandleItemCLick)
        }
    }

    open fun onBindData(itemData: T) {
        this.data = itemData
    }

    open fun onHandleItemCLick(mainItem: T) = Unit
}
