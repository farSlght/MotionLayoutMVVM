package com.example.testapp.utils

import com.example.testapp.domain.adapters.RecyclerDslAdapter


fun recyclerAdapter(configure: AdapterDsl.() -> Unit): RecyclerDslAdapter {
    return AdapterDsl().apply(configure).makeAdapter()
}