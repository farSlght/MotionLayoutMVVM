package com.example.testapp.repository.implementations

import com.example.testapp.domain.model.Plan
import com.example.testapp.network.OmniViewApi
import com.example.testapp.repository.interfaces.IPlanRepository
import com.example.testapp.repository.model.PlanResponce
import io.reactivex.Single

class PlanRepository(
        private val api: OmniViewApi
) : IPlanRepository {
    override fun getDailyPlans(): Single<List<Plan>> = Single.just(listOf(
            Plan("Today, 26 Apr", "todaysPlan is 86 kilo")
    ))    // api.getTodaysPlan()

}