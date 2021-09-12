package com.nikitakonshin.myteststore.view_model

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.repositories.interactors.ProductDetailsInteractor

class ProductDetailsViewModel(private val interactor: ProductDetailsInteractor) :
    BaseViewModel<List<ProductDetails>>() {
    fun getData() = runAsync {
        _liveData.value = AppState.Success(interactor.getProductDetails())
    }
}