package com.example.testapp.view

import android.os.Bundle
import com.example.testapp.R
import com.example.testapp.utils.extensions.nonNullObserve
import com.example.testapp.viewModel.main.MainViewModel
import kotlinx.android.synthetic.main.item_dailyplan.*
import kotlinx.android.synthetic.main.page_dailyplan.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val items = (1..20).map { "item $it" }

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView.apply {
//            adapter = SimpleAdapter(items)
//            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
//        }

        vm.date.nonNullObserve(this) { tv_day.text = it }
        vm.plan.nonNullObserve(this) { tv_dailyplan.text = it }
        vm.load()
    }
}
