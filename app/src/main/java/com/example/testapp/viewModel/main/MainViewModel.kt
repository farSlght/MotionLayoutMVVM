package com.example.testapp.viewModel.main

import android.arch.lifecycle.MutableLiveData
import com.example.testapp.domain.interfaces.ISetupInteractor
import com.example.testapp.domain.model.Plan
import com.example.testapp.system.ISchedulers
import com.example.testapp.viewModel.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import ru.terrakok.cicerone.Router

class MainViewModel(
        router: Router,
        schedulers: ISchedulers,
        private val interactor: ISetupInteractor
) : BaseViewModel(router, schedulers) {

    val date = MutableLiveData<String>()
    val plan = MutableLiveData<String>()

    private val cd = CompositeDisposable()

    fun load(){
        interactor.doSetup()
                .toSingle { Unit }
                .flatMap{ interactor.loadPlan() }
                .manageSchedulers()
                .subscribe (::handlePlan, ::handleError)
                .addTo(cd)
    }

    private fun handlePlan(Plan: Plan) {
        date.value = Plan.date
        plan.value = Plan.plan
    }
}