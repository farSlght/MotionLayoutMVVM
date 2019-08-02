package com.example.testapp.domain.model

import com.example.testapp.domain.interfaces.IListItem

data class Plan(val date: String, val todaysPlan: String) : IListItem {
    override val id: String?
        get() = todaysPlan
}