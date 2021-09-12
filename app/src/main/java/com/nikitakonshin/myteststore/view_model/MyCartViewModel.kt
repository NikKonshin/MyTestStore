package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.local.cart.Cart
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.repositories.interactors.MyCartInteractor

class MyCartViewModel(private val interactor: MyCartInteractor) :
    BaseViewModel<List<Cart>>() {

    fun getData() = runAsync {
        _liveData.value = AppState.Success(interactor.getCart())
    }
}