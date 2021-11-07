package com.nikitakonshin.feature_my_cart.domain

import com.nikitakonshin.feature_my_cart.data.model.local.Cart

class MyCartInteractorImpl(private val repository: MyCartRepository) :
    MyCartInteractor {

    override suspend fun getCart(): Cart = repository.getCart()
}