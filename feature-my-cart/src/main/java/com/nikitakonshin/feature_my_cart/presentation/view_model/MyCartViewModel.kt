package com.nikitakonshin.feature_my_cart.presentation.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.feature_my_cart.domain.MyCartInteractor
import com.nikitakonshin.feature_my_cart.presentation.navigation.MyCartNavigator
import com.nikitakonshin.model.entities.local.cart.Cart
import com.nikitakonshin.model.state.AppState

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