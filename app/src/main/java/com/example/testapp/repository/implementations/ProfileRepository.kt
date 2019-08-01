package com.example.testapp.repository.implementations

import com.example.testapp.network.OmniViewApi
import com.example.testapp.repository.interfaces.IPlanRepository
import com.example.testapp.repository.model.Plan
import io.reactivex.Observable
import io.reactivex.Single

class PlanRepository(
        private val api: OmniViewApi
) : IPlanRepository {
    override fun getPlan(): Single<Plan> = Single.just(Plan("Today, 26 Apr", "plan is 86 kilo"))    // api.getPlan()

}