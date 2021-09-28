package com.nikitakonshin.feature_main_screen.presentation.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.feature_main_screen.domain.MainInteractor
import com.nikitakonshin.feature_main_screen.presentation.navigation.MainScreenNavigator
import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.model.state.AppState

class MainScreenViewModel(
    private val interactor: MainInteractor,
    private val navigator: MainScreenNavigator
) :
    BaseViewModel<Main>() {

    fun getData() = runAsync {
        showLoading()
        _liveData.postValue(AppState.Success(interactor.getMain()))
    }

    fun toProductDetailsScreen(id: String){
        navigator.toProductDetailsScreen(id)
    }
}