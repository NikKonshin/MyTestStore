package com.nikitakonshin.feature_main_screen.presentation.navigation

import com.nikitakonshin.core.navigation.BaseNavigator

interface MainScreenNavigator : BaseNavigator {
    fun toProductDetailsScreen(id: String)
}
