package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.repositories.interactors.MainInteractor

class MainScreenViewModel(private val interactor: MainInteractor) :
    BaseViewModel<List<Main>>() {

    fun getData() = runAsync {
        _liveData.value = AppState.Success(interactor.getMain())
    }
}