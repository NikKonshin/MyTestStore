package com.nikitakonshin.myteststore.view_model

import androidx.lifecycle.ViewModel
import com.nikitakonshin.myteststore.navigation.SplashNavigator
import kotlinx.coroutines.*

class SplashViewModel(private val navigation: SplashNavigator) : ViewModel() {

    private val viewModelCoroutineScope =
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        )

    fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    fun toMainScreen(timeMillis: Long) {
        viewModelCoroutineScope.launch {
            delay(timeMillis)
            navigation.toMainScreen()
        }
    }
}