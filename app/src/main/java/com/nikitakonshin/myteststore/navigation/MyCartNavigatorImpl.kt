package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.Router
import com.nikitakonshin.feature_my_cart.presentation.navigation.MyCartNavigator

class MyCartNavigatorImpl(
    private val screens: Screens,
    private val router: Router
): MyCartNavigator {
    override fun onBackPressed() {
        router.exit()
    }
}