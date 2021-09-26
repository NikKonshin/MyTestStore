package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.local.cart.Cart
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.myteststore.navigation.MyCartNavigator
import com.nikitakonshin.repositories.interactors.MyCartInteractor

class MyCartViewModel(
    private val interactor: MyCartInteractor,
    private val navigator: MyCartNavigator
) :
    BaseViewModel<Cart>() {

    fun getData() = runAsync {
        _liveData.postValue(AppState.Success(interactor.getCart()))
    }

    fun onBackPressed(){
        navigator.onBackPressed()
    }
}