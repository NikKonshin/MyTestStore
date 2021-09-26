package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.nikitakonshin.myteststore.view.fragments.MainScreenFragment
import com.nikitakonshin.myteststore.view.fragments.MyCartFragment
import com.nikitakonshin.myteststore.view.fragments.ProductDetailsFragment
import com.nikitakonshin.myteststore.view.fragments.SplashFragment

class Screens {
    fun mainScreen() = FragmentScreen { MainScreenFragment() }
    fun myCartScreen() = FragmentScreen { MyCartFragment() }
    fun productDetailsScreen(id: String) = FragmentScreen { ProductDetailsFragment.newInstance(id) }
    fun splashScreen() = FragmentScreen { SplashFragment() }
}