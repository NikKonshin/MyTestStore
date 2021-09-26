package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.Router

class MainScreenNavigatorImpl(
    private val screens: Screens,
    private val router: Router
) : MainScreenNavigator {
    override fun toProductDetailsScreen(id: String) {
        router.navigateTo(screens.productDetailsScreen(id))
    }

    override fun onBackPressed() {
        router.exit()
    }
}