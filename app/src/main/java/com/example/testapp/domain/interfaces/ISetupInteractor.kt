package com.example.testapp.domain.interfaces

import com.example.testapp.domain.model.Plan
import io.reactivex.Completable
import io.reactivex.Single

interface ISetupInteractor {
    fun doSetup(): Completable
    fun loadPlan(): Single<List<Plan>>
}