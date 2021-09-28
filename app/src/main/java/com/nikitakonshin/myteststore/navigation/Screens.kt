package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.nikitakonshin.feature_main_screen.presentation.fragment.MainScreenFragment
import com.nikitakonshin.feature_my_cart.presentation.fragment.MyCartFragment
import com.nikitakonshin.feature_product_details.presentation.fragment.ProductDetailsFragment
import com.nikitakonshin.feature_splash_screen.fragment.SplashFragment

class Screens {
    fun mainScreen() = FragmentScreen { MainScreenFragment() }
    fun myCartScreen() = FragmentScreen { MyCartFragment() }
    fun productDetailsScreen(id: String) = FragmentScreen { ProductDetailsFragment.newInstance(id) }
    fun splashScreen() = FragmentScreen { SplashFragment() }
}