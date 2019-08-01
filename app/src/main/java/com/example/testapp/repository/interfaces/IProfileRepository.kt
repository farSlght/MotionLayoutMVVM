package com.example.testapp.repository.interfaces

import com.example.testapp.repository.model.Plan
import io.reactivex.Single

interface IPlanRepository {
    fun getPlan(): Single<Plan>
}