package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.nikitakonshin.myteststore.view.fragments.MainScreenFragment
import com.nikitakonshin.myteststore.view.fragments.MyCartFragment
import com.nikitakonshin.myteststore.view.fragments.ProductDetailsFragment

class Screens {
    fun mainScreen() = FragmentScreen { MainScreenFragment() }
    fun myCartScreen() = FragmentScreen { MyCartFragment() }
    fun productDetailsScreen() = FragmentScreen { ProductDetailsFragment() }
}