package com.nikitakonshin.myteststore.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.view.fragments.MainScreenFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val navigatorHolder: NavigatorHolder by inject()
    private var navigator: AppNavigator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator = AppNavigator(this,R.id.container)
        navigator?.let {
            navigatorHolder.setNavigator(it)
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment()).commit()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}