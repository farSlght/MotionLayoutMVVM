package com.example.testapp.domain.implementations

import com.example.testapp.domain.interfaces.IListItem
import com.example.testapp.domain.interfaces.ISetupInteractor
import com.example.testapp.domain.model.Plan
import com.example.testapp.repository.interfaces.IAuthRepository
import com.example.testapp.repository.interfaces.IPlanRepository
import io.reactivex.Completable
import io.reactivex.Single

class SetupInteractor(
        private val authRepository: IAuthRepository,
        private val PlansRepository: IPlanRepository
) : ISetupInteractor {
    override fun doSetup(): Completable = authRepository.isAuthorized()
            .map {
                //todo handle auth state
                Unit
            }.ignoreElement()

    override fun loadPlan(): Single<List<Plan>> = PlansRepository.getDailyPlans().map { it}
}