package com.example.testapp.view

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.testapp.R
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Forward
import java.util.*

abstract class BaseActivity : AppCompatActivity(){
    protected val navigatorHolder: NavigatorHolder by inject()

    protected val navigator = object : SupportAppNavigator(this,
            R.id.container
    ) {
        var lastNavigationEvent = Date().time

        override fun fragmentForward(command: Forward?) {
            if(Date().time - lastNavigationEvent > 500){
                lastNavigationEvent = Date().time
                super.fragmentForward(command)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        listenToVm()
        listenToUi()
    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    abstract fun listenToVm()
    abstract fun listenToUi()
}