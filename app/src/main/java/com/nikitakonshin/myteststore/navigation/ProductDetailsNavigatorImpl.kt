package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.Router

class ProductDetailsNavigatorImpl(
    private val screens: Screens,
    private val router: Router) : ProductDetailsNavigator {

   override fun onBackPressed() {
        router.exit()
    }

    override fun toMyCartFragment() {
        router.navigateTo(screens.myCartScreen())
    }
}