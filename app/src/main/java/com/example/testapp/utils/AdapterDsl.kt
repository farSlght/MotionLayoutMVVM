package com.example.testapp.utils

import android.support.v7.widget.RecyclerView
import com.example.testapp.domain.adapters.RecyclerDslAdapter
import com.example.testapp.domain.interfaces.IListItem

class AdapterDsl {

    var enablePaging: Boolean = false

    fun bind(binder: (RecyclerView.ViewHolder, IListItem) -> Unit) {
        this.binder = binder
    }

    fun viewLayout(layoutSelector: (IListItem) -> Int) {
        viewLayoutSelector = layoutSelector
    }


    private var binder: (RecyclerView.ViewHolder, IListItem) -> Unit = { _, _ -> }
    private var viewLayoutSelector: (IListItem) -> Int = { throw NotImplementedError() }

    fun makeAdapter(): RecyclerDslAdapter =
        RecyclerDslAdapter(binder).apply { isPagingEnabled = enablePaging }
}

