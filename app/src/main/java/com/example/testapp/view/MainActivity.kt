package com.example.testapp.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.model.Plan
import com.example.testapp.utils.extensions.nonNullObserve
import com.example.testapp.utils.recyclerAdapter
import com.example.testapp.viewModel.main.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_dailyplan.view.*
import kotlinx.android.synthetic.main.page_dailyplan.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val vm: MainViewModel by viewModel()
    private val plansAdpter by lazy {
        recyclerAdapter {
            enablePaging = true
            viewLayout { iListItem -> R.layout.page_dailyplan }
            bind { viewHolder, item ->
                if (item !is Plan) return@bind
                viewHolder.run {
                itemView.tv_day.text = item.date
                itemView.tv_dailyplan.text = item.todaysPlan
            } }
        }
    }

//    private val pagerAdapter by lazy {
//        TwoWayPagerAdapter(childFragmentManager)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.load()
    }

    override fun listenToVm() {
        vm.apply {
            plans.nonNullObserve(this@MainActivity) {
                initPlansAdapter(it)
            }
        }
    }

    override fun listenToUi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initPlansAdapter(dailyPlans: List<Plan>?) {
        plansAdpter.dispatchItems(dailyPlans ?: listOf())
        rv_dailyPlan.layoutManager = LinearLayoutManager(this)
        rv_dailyPlan.adapter = plansAdpter
    }
}
