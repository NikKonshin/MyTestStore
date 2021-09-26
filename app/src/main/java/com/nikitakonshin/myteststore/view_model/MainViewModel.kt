package com.nikitakonshin.myteststore.view_model

import androidx.lifecycle.ViewModel
import com.nikitakonshin.myteststore.navigation.MainNavigator

class MainViewModel(private val navigator: MainNavigator): ViewModel() {

    fun toSplashScreen(){
        navigator.toSplashScreen()
    }
}