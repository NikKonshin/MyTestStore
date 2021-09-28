package com.nikitakonshin.feature_product_details.presentation.view_moldel

import com.nikitakonshin.core.view_model.BaseViewModel
import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.model.state.AppState
import com.nikitakonshin.feature_product_details.presentation.navigation.ProductDetailsNavigator
import com.nikitakonshin.feature_product_details.domain.ProductDetailsInteractor

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