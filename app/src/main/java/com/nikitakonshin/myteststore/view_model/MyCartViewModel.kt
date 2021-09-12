package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.responce.cart.ResponseCart
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class MyCartViewModel(private val repository: RemoteDataSource) : BaseViewModel<List<ResponseCart>>() {

    fun getData() = runAsync {
        _liveData.value = AppState.Success(repository.getMyCart())
    }
}