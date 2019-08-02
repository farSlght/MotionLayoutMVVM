package com.example.testapp.repository.interfaces

import com.example.testapp.domain.model.Plan
import com.example.testapp.repository.model.PlanResponce
import io.reactivex.Single

interface IPlanRepository {
    fun getDailyPlans(): Single<List<Plan>>
}