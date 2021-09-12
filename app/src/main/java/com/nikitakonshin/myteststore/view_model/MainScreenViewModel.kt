package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.Main
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class MainScreenViewModel(private val repository: RemoteDataSource) : BaseViewModel<List<Main>>() {

    fun getData() = runAsync {
        _liveData.value = AppState.Success(repository.getMain())
    }
}