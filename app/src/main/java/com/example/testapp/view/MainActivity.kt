package com.example.testapp.view

import android.os.Bundle
import com.example.testapp.R
import com.example.testapp.utils.extensions.nonNullObserve
import com.example.testapp.viewModel.main.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.fullName.nonNullObserve(this) { fullname.text = it }
        vm.email.nonNullObserve(this) { email.text = it }
        vm.load()
    }
}
