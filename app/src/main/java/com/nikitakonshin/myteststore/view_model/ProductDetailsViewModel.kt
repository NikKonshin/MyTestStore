package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.myteststore.navigation.ProductDetailsNavigator
import com.nikitakonshin.repositories.interactors.ProductDetailsInteractor

class ProductDetailsViewModel(
    private val interactor: ProductDetailsInteractor,
    private val navigator: ProductDetailsNavigator
) :
    BaseViewModel<ProductDetails>() {
    fun getData(id: String) = runAsync {
        val data = interactor.getProductDetails(id)
        data?.let { _liveData.postValue(AppState.Success(it)) }
    }

    fun onBackPressed() {
        navigator.onBackPressed()
    }

    fun toMyCartScreen() {
        navigator.toMyCartFragment()
    }
}