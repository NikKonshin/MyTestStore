package com.nikitakonshin.myteststore.navigation

import com.github.terrakok.cicerone.Router

class MyCartNavigatorImpl(
    private val screens: Screens,
    private val router: Router
): MyCartNavigator {
    override fun onBackPressed() {
        router.exit()
    }
}